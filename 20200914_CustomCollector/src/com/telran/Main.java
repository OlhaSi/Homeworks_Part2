package com.telran;

import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        double resEven = Stream.of(24, 18, 10, 23)
                .collect(new MedianElementCollecting());
        System.out.println(resEven);

        double resOdd = Stream.of(24, 18, 23)
                .collect(new MedianElementCollecting());
        System.out.println(resOdd);
    }
}
