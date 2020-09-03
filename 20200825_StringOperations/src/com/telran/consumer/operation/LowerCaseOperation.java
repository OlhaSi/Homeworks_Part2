package com.telran.consumer.operation;

import com.telran.consumer.StringOperation;

public class LowerCaseOperation implements StringOperation {

    private static final String NAME = "lowerCase";


    @Override
    public String operate(String line) {
        return line.toLowerCase();
    }

    @Override
    public String getOperationName() {
        return NAME;
    }
}
