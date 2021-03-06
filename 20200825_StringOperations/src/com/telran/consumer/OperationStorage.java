package com.telran.consumer;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * After instantiating an object, the client must invoke the init init() method, which completes
 * the instantiation of the object.
 */

public class OperationStorage {

    Map<String, StringOperation> operationByName;

    public OperationStorage(){
        operationByName = new HashMap<>();
    }

    /**
     * The method fills operationByName object
     * @param paths of the operation to initialize
     */
    public void init (List<String> paths) throws ClassNotFoundException, OperationStorageInstantiationException{
        operationByName = new HashMap<>();

        try {
            for (String path : paths){
                StringOperation operation = (StringOperation) Class.forName(path)
                        .getConstructor().newInstance();
                operationByName.put(operation.getOperationName(), operation);
            }
        } catch (NoSuchMethodException | IllegalAccessException |
                InvocationTargetException | InstantiationException e){
            throw new OperationStorageInstantiationException(e.getMessage(), e);
        }
    }

    public StringOperation getByName(String name){
        return operationByName.get(name);
    }
}
