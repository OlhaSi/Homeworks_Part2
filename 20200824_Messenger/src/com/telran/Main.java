package com.telran;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        // create 3 same consumers and one supplier, make consumers daemon.
        OneElementBlockingQueue queue = new OneElementBlockingQueue();

        StringSupplier stringSupplier = new StringSupplier(queue);
        stringSupplier.setDaemon(true);
        stringSupplier.start();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line;
        while ((line = br.readLine()) != null && !line.equals("exit")) {
            stringSupplier.interrupt();
        }

        StringConsumer stringConsumer1 = new StringConsumer(queue);
        StringConsumer stringConsumer2 = new StringConsumer(queue);
        StringConsumer stringConsumer3 = new StringConsumer(queue);

        stringConsumer1.start();
        stringConsumer2.start();
        stringConsumer3.start();

    }
}
