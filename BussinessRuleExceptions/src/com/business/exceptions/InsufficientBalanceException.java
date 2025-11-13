package com.business.exceptions;

public class InsufficientBalanceException extends BusinessException {
    public InsufficientBalanceException(String msg) {
        super(msg);
    }
}
