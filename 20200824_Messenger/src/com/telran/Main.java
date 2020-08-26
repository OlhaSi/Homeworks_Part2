package com.telran;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        // create 3 same consumers and one supplier, make consumers daemon.

        OneElementBlockingQueue queue = new OneElementBlockingQueue();
        Thread supplier = new StringSupplier(queue);

        Thread[] consumers = new StringConsumer[5];

        for (int i = 0; i < consumers.length; i++) {
            consumers[i] = new StringConsumer(queue);
            consumers[i].setDaemon(true);
            consumers[i].start();
        }
        supplier.start();

    }
}
