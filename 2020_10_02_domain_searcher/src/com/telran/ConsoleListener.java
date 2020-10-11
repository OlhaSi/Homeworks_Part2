package com.telran;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class ConsoleListener implements Runnable {

    DomainChecker domainChecker;

    public ConsoleListener(DomainChecker domainChecker) {
        this.domainChecker = domainChecker;
    }

    @Override
    public void run() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            String line;
            while (((line = br.readLine()) != null && !line.equals("exit"))) {
                List<String> freeDomains = domainChecker.getFreeDomains(line);
                freeDomains.forEach(System.out::println);
                if (freeDomains.isEmpty())
                    System.out.println("No free domains found");
                else
                    System.out.println("Completed!");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
