package com.solvd.laba.rbekrenov.travelagency.exception;

public class IncorrectAmountException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Amount value must be positive, rejected value: %.2f";
    public IncorrectAmountException(double amount) {
        super(MESSAGE_TEMPLATE.formatted(amount));
    }
}
