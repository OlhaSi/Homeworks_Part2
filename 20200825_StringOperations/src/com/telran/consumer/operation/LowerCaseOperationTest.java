package com.telran.consumer.operation;

import com.telran.consumer.StringOperation;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LowerCaseOperationTest {

    StringOperation operation = new LowerCaseOperation();

    @Test
    public void testOperate_emptyString_emptyString(){
        assertEquals("", operation.operate(""));
    }

    @Test
    public void testOperate_upperCaseString_lowerCaseString(){
        assertEquals("abc", operation.operate("ABC"));
    }

    @Test
    public void testOperate_mixedStringWithSymbols_lowerCaseString(){
        assertEquals("ash*sg$f", operation.operate("aSh*sG$f"));
    }
}