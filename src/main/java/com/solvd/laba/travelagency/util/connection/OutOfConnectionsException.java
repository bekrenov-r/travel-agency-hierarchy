package com.solvd.laba.travelagency.util.connection;

public class OutOfConnectionsException extends RuntimeException {
    public OutOfConnectionsException() {
    }

    public OutOfConnectionsException(String message) {
        super(message);
    }
}
