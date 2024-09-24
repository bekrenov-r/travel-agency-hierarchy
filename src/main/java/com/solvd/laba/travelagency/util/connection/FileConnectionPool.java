package com.solvd.laba.travelagency.util.connection;

import java.io.File;
import java.util.concurrent.CopyOnWriteArrayList;

public class FileConnectionPool {
    private static FileConnectionPool INSTANCE;
    private final File file;
    private final int size;
    private CopyOnWriteArrayList<FileConnection> connections;
    private CopyOnWriteArrayList<FileConnection> usedConnections;

    private FileConnectionPool(String filePath, int poolSize) {
        this.file = new File(filePath);
        this.size = poolSize;
    }

    public synchronized static FileConnectionPool getInstance(String filePath, int poolSize) {
        if(INSTANCE == null) {
            INSTANCE = new FileConnectionPool(filePath, poolSize);
        }
        return INSTANCE;
    }

    public synchronized FileConnection getConnection() {
        if(connections == null) {
            initPool();
        }
        if(connections.isEmpty()) {
            throw new OutOfConnectionsException();
        }
        FileConnection conn = connections.remove(connections.size() - 1);
        this.usedConnections.add(conn);
        return conn;
    }

    public void release(FileConnection connection){
        this.usedConnections.remove(connection);
        this.connections.add(connection);
    }

    private void initPool(){
        this.connections = new CopyOnWriteArrayList<>();
        this.usedConnections = new CopyOnWriteArrayList<>();
        for (int i = 0; i < size; i++) {
            this.connections.add(new FileConnectionImpl(file));
        }
    }
}
