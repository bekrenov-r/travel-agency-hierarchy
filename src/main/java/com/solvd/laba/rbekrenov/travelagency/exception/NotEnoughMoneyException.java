package com.solvd.laba.rbekrenov.travelagency.exception;

public class NotEnoughMoneyException extends RuntimeException {
    public NotEnoughMoneyException() {
        super("Not enough money for this operation");
    }
}
