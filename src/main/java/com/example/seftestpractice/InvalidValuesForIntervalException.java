package com.example.seftestpractice;

public class InvalidValuesForIntervalException extends RuntimeException {
    public InvalidValuesForIntervalException(String errorAtIntervalValues) {
        super(errorAtIntervalValues);
    }
}
