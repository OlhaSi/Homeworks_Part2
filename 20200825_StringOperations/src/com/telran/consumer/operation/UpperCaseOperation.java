package com.telran.consumer.operation;

import com.telran.consumer.StringOperation;

public class UpperCaseOperation implements StringOperation {

    private static final String NAME = "upperCase";

    @Override
    public String operate(String line) {
        return line.toUpperCase();
    }

    @Override
    public String getOperationName() {
        return NAME;
    }
}
