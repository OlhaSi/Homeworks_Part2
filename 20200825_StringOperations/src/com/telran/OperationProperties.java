package com.telran;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public class OperationProperties {

    private static String OPERATIONS_KEY = "operations";
    Properties properties;
    String filePath;

    public OperationProperties(String filePath) {
        properties = new Properties();
        this.filePath = filePath;
    }

    public void load() throws IOException {
        properties.load(new FileReader(filePath));
    }

    public String getPropertyByName(String propertyName){
        return properties.getProperty(propertyName);
    }

    public List<String> getOperationPaths(){
        String stringPaths = properties.getProperty(OPERATIONS_KEY);
        String[] arrayPath = stringPaths.split(",");
        return Arrays.asList(arrayPath);
    }
}
