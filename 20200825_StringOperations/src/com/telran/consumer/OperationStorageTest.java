package com.telran.consumer;

import com.telran.consumer.operation.LowerCaseOperation;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class OperationStorageTest {

    OperationStorage operationStorage = new OperationStorage();

    @Test
    public void testInit_oneExistingOperation_filledStorage() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        operationStorage.init(Arrays.asList("com.telran.consumer.operation.LowerCaseOperation"));

        assertEquals(1, operationStorage.operationByName.size());
        StringOperation operation = operationStorage.operationByName.get("lowerCase");

        assertTrue(operation instanceof LowerCaseOperation);
        //assertTrue(LowerCaseOperation.class.isInstance(operation));  - another option to get the same
    }

}