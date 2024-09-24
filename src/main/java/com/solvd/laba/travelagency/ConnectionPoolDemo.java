package com.solvd.laba.travelagency;

import com.solvd.laba.travelagency.util.connection.FileConnection;
import com.solvd.laba.travelagency.util.connection.FileConnectionPool;
import com.solvd.laba.travelagency.util.connection.OutOfConnectionsException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ConnectionPoolDemo {
    private static final Logger log = LogManager.getLogger(ConnectionPoolDemo.class);
    private static FileConnectionPool connectionPool = FileConnectionPool.getInstance("src/main/resources/file.txt", 5);
    public static void main(String[] args) {
        ExecutorService execService = Executors.newFixedThreadPool(7);
        for (int i = 0; i < 7; i++) {
            CompletableFuture
                    .runAsync(() -> {
                        FileConnection connection = connectionPool.getConnection();
                        appendToFile("Something\n", connection);
                    }, execService)
                    .handle((c, t) -> {
                        if (t.getCause() instanceof OutOfConnectionsException) {
                            log.info("Retrying to get connection");
                            return retryAsync().join();
                        } else {
                            log.error(t.getMessage(), t);
                            return CompletableFuture.completedFuture(null);
                        }
                    })
                    .thenAccept(c -> {
                        FileConnection connection = (FileConnection) c;
                        appendToFile("Something\n", connection);
                    });
        }
        execService.shutdown();
    }

    private static CompletableFuture<FileConnection> retryAsync() {
        return CompletableFuture.supplyAsync(() -> {
            while(true) {
                try {
                    Thread.sleep(500);
                    return connectionPool.getConnection();
                } catch (OutOfConnectionsException ex) {

                } catch(InterruptedException ex) {
                    log.error(ex.getMessage(), ex);
                }
            }
        });
    }

    private static void appendToFile(String s, FileConnection connection) {
        log.info("Writing to file");
        String fileContent = connection.readFromFile();
        connection.writeToFile(fileContent + s);
        connectionPool.release(connection);
    }
}
