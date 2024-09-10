package com.solvd.laba.travelagency.exception;

public class NotEnoughMoneyException extends Exception {
    private static final String MESSAGE = "Not enough money for this operation";
    public NotEnoughMoneyException() {
        super(MESSAGE);
    }

    public NotEnoughMoneyException(String message) {
        super(message);
    }
}
