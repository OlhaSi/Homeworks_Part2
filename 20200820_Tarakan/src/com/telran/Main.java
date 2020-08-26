package com.telran;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        // initialize score list. Then initialize and start all tarakans.
        // Then join all the tarakans. Then print the scores out.

        List<Score> scoreList = new ArrayList<>();

        Tarakan t1 = new Tarakan("Rony", 15, scoreList);
        Tarakan t2 = new Tarakan("Peggy", 20, scoreList);
        Tarakan t3 = new Tarakan("Jecky", 10, scoreList);
        Tarakan t4 = new Tarakan("Rex", 50, scoreList);
        Tarakan t5 = new Tarakan("Hurry", 30, scoreList);

        Thread th1 = new Thread(t1);
        Thread th2 = new Thread(t2);
        Thread th3 = new Thread(t3);
        Thread th4 = new Thread(t4);
        Thread th5 = new Thread(t5);

        th1.start();
        th2.start();
        th3.start();
        th4.start();
        th5.start();

        th1.join();
        th2.join();
        th3.join();
        th4.join();
        th5.join();

        System.out.println(scoreList);

    }
}
