package com.solvd.laba.travelagency.exception;

public class NotEnoughMoneyException extends Exception {
    public NotEnoughMoneyException() {
        super("Not enough money for this operation");
    }
}
