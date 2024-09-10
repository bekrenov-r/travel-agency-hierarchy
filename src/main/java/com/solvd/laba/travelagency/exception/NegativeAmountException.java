package com.solvd.laba.travelagency.exception;

public class NegativeAmountException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Amount value must be positive, rejected value: %.2f";

    public NegativeAmountException(double amount) {
        super(MESSAGE_TEMPLATE.formatted(amount));
    }

    public NegativeAmountException(String message) {
        super(message);
    }
}
