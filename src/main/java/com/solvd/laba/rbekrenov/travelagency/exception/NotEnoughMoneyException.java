package com.solvd.laba.rbekrenov.travelagency.exception;

public class NotEnoughMoneyException extends Exception {
    public NotEnoughMoneyException() {
        super("Not enough money for this operation");
    }
}
