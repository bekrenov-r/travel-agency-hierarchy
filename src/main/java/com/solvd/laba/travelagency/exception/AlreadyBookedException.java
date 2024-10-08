package com.solvd.laba.travelagency.exception;

public class AlreadyBookedException extends RuntimeException {
    private static final String MESSAGE = "Cannot book already booked item";

    public AlreadyBookedException() {
        super(MESSAGE);
    }

    public AlreadyBookedException(String message) {
        super(message);
    }
}
