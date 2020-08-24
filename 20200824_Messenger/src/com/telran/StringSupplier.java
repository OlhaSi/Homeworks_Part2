package com.telran;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StringSupplier extends Thread {

    private final OneElementBlockingQueue queue;

    public StringSupplier(OneElementBlockingQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {

        while (true) {
            try {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                String line = br.readLine();
                queue.addFirst(line);

                System.out.println(line + " " + this.getId());
            } catch (InterruptedException | IOException e) {
                e.printStackTrace();
            }
        }
    }
}
