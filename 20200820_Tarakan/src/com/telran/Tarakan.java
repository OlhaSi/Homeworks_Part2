package com.telran;

import java.util.List;
import java.util.Random;

public class Tarakan implements Runnable {

    private static final int FASTEST_STEP = 50;
    private static final int LONGEST_STEP = 100;

    String name;
    int stepsNum;
    final List<Score> scores;
    Random r = new Random(FASTEST_STEP);

    public Tarakan(String name, int stepsNum, List<Score> scores) {
        this.name = name;
        this.stepsNum = stepsNum;
        this.scores = scores;
    }

    @Override
    public void run() {
        long start = System.currentTimeMillis();

        for (int i = 0; i < stepsNum; i++) {
            try {
                Thread.sleep(r.nextInt(LONGEST_STEP));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        long finish;
        synchronized (scores){
            finish = System.currentTimeMillis();
        }

        synchronized (scores){
            scores.add(new Score(name, (int) (finish - start)));
        }
    }
}
