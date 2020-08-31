package com.telran.consumer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.stubbing.OngoingStubbing;

import java.io.PrintWriter;
import java.util.concurrent.BlockingQueue;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class LineConsumerTest {

    LineConsumer lineConsumer;

    BlockingQueue<String> lineDeque;
    PrintWriter pw;
    OperationStorage operationStorage;

    @BeforeEach
    public void init() {
        lineDeque = mock(BlockingQueue.class);
        pw = mock(PrintWriter.class);
        operationStorage = mock(OperationStorage.class);

        lineConsumer = new LineConsumer(lineDeque, operationStorage, pw);
    }

    @Test
    public void testProcessLine_textWithoutOperation_wrongLine() {
        String toProcess = "hello";
        String expected = "hello" + LineConsumer.DELIMITER + LineConsumer.WRONG_LINE;

        assertEquals(expected, lineConsumer.processLine(toProcess));
    }

    @Test
    public void testProcessLine_textWithoutOperation_wrongOperation() {
        String toProcess = "hello#some_operation";

        when(operationStorage.getByName("some_operation")).thenReturn(null);

        String expected = toProcess + LineConsumer.DELIMITER + LineConsumer.WRONG_OPERATION;

        assertEquals(expected, lineConsumer.processLine(toProcess));
    }

    @Test
    public void testProcessLine_textWithRightOperation_transformedText() {
        String toProcess = "hello#some_operation";

        StringOperation someOperation = mock(StringOperation.class);
        when(someOperation.operate("hello")).thenReturn("HellO");
        when(operationStorage.getByName("some_operation")).thenReturn(someOperation);

        String expected = "HellO";

        assertEquals(expected, lineConsumer.processLine(toProcess));
    }

    @Test
    public void testProcessLine_textWithUpperCaseOperation_transformedText() {
        String toProcess = "hello#upperCase";

        StringOperation upperCaseOperation = mock(StringOperation.class);
        when(upperCaseOperation.operate("hello")).thenReturn("HELLO");
        when(operationStorage.getByName("upperCase")).thenReturn(upperCaseOperation);

        String expected = "HELLO";

        assertEquals(expected, lineConsumer.processLine(toProcess));
    }

    @Test
    public void testProcessLine_textWithMixedUpperCaseOperation_transformedText() {
        String toProcess = "hE5llo%#upperCase";

        StringOperation upperCaseOperation = mock(StringOperation.class);
        when(upperCaseOperation.operate("hE5llo%")).thenReturn("HE5LLO%");
        when(operationStorage.getByName("upperCase")).thenReturn(upperCaseOperation);

        String expected = "HE5LLO%";

        assertEquals(expected, lineConsumer.processLine(toProcess));
    }

    @Test
    public void testProcessLine_textWithLowerCaseOperation_transformedText() {
        String toProcess = "JAVA#lowerCase";

        StringOperation lowerCaseOperation = mock(StringOperation.class);
        when(lowerCaseOperation.operate("JAVA")).thenReturn("java");
        when(operationStorage.getByName("lowerCase")).thenReturn(lowerCaseOperation);

        String expected = "java";

        assertEquals(expected, lineConsumer.processLine(toProcess));
    }

    @Test
    public void testProcessLine_textWithMixedLowerCaseOperation_transformedText() {
        String toProcess = "JaV&A8#lowerCase";

        StringOperation lowerCaseOperation = mock(StringOperation.class);
        when(lowerCaseOperation.operate("JaV&A8")).thenReturn("jav&a8");
        when(operationStorage.getByName("lowerCase")).thenReturn(lowerCaseOperation);

        String expected = "jav&a8";

        assertEquals(expected, lineConsumer.processLine(toProcess));
    }

    @Test
    public void testProcessLine_textWithReverseOperation_transformedText() {
        String toProcess = "Java#reverse";

        StringOperation reverseCaseOperation = mock(StringOperation.class);
        when(reverseCaseOperation.operate("Java")).thenReturn("avaJ");
        when(operationStorage.getByName("reverse")).thenReturn(reverseCaseOperation);

        String expected = "avaJ";

        assertEquals(expected, lineConsumer.processLine(toProcess));
    }

    @Test
    public void testProcessLine_textWithMixedReverseOperation_transformedText() {
        String toProcess = "J$A4va#reverse";

        StringOperation reverseCaseOperation = mock(StringOperation.class);
        when(reverseCaseOperation.operate("J$A4va")).thenReturn("av4A$J");
        when(operationStorage.getByName("reverse")).thenReturn(reverseCaseOperation);

        String expected = "av4A$J";

        assertEquals(expected, lineConsumer.processLine(toProcess));
    }

}