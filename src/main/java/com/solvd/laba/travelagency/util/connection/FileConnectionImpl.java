package com.solvd.laba.travelagency.util.connection;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class FileConnectionImpl implements FileConnection {
    private static final Logger log = LogManager.getLogger(FileConnectionImpl.class);
    private final File file;

    public FileConnectionImpl(File file) {
        this.file = file;
    }

    @Override
    public void writeToFile(String content) {
        try {
            FileUtils.writeStringToFile(file, content, StandardCharsets.UTF_8);
            Thread.sleep(2000);
        } catch (InterruptedException | IOException ex) {
            log.error(ex.getMessage(), ex);
        }
    }

    @Override
    public String readFromFile() {
        try {
            return FileUtils.readFileToString(file, StandardCharsets.UTF_8);
        } catch(IOException ex) {
            log.error(ex.getMessage(), ex);
            return "";
        }
    }

    @Override
    public File getFile() {
        return file;
    }
}
