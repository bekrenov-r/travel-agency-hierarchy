package com.solvd.laba.travelagency.exception;

public class AlreadyPaidException extends Exception {
    private static final String MESSAGE = "Attempted to process already finished payment";

    public AlreadyPaidException() {
        super(MESSAGE);
    }

    public AlreadyPaidException(String message) {
        super(message);
    }
}
