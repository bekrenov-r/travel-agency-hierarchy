package com.solvd.laba.travelagency.util.connection;

import java.io.File;

public interface FileConnection {
    void writeToFile(String content);
    String readFromFile();
    File getFile();
}
