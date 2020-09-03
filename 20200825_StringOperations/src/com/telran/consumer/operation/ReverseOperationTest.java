package com.telran.consumer.operation;

import com.telran.consumer.StringOperation;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReverseOperationTest {

    StringOperation operation = new ReverseOperation();

    @Test
    public void testOperate_emptyString_emptyString(){
        assertEquals("", operation.operate(""));
    }

    @Test
    public void testOperate_1element_1element(){
        assertEquals("a", operation.operate("a"));
    }

    @Test
    public void testOperate_2elements_2reversedElements(){
        assertEquals("ab", operation.operate("ba"));
    }

    @Test
    public void testOperate_mixedStringWithSymbols_reversedMixedString(){
        assertEquals("f$Gs*hSa", operation.operate("aSh*sG$f"));
    }

}