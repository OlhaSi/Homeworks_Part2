package com.telran.consumer.operation;

import com.telran.consumer.StringOperation;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UpperCaseOperationTest {

    StringOperation operation = new UpperCaseOperation();

    @Test
    public void testOperate_emptyString_emptyString(){
        assertEquals("", operation.operate(""));
    }

    @Test
    public void testOperate_lowerCaseString_upperCaseString(){
        assertEquals("ABC", operation.operate("abc"));
    }

    @Test
    public void testOperate_mixedStringWithSymbols_upperCaseString(){
        assertEquals("ASH*SG$F", operation.operate("aSh*sG$f"));
    }

}