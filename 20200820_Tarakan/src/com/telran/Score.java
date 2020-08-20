package com.telran;

public class Score {

    private String name;
    private int duration;

    public Score(String name, int duration) {
        this.name = name;
        this.duration = duration;
    }

    public String getName() {
        return name;
    }

    public int getDuration() {
        return duration;
    }

    @Override
    public String toString() {
        return "Name: " + name +
                ", duration: " + duration;
    }
}
