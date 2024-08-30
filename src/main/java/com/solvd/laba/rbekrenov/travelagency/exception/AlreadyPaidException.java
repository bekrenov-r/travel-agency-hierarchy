package com.solvd.laba.rbekrenov.travelagency.exception;

public class AlreadyPaidException extends Exception {
    private static final String MESSAGE = "Attempted to process already finished payment";

    public AlreadyPaidException() {
        super(MESSAGE);
    }
}
