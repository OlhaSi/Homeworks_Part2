package com.telran;

import java.util.Arrays;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class CombineStreams {

    public IntStream combine(IntStream stream1, IntStream stream2) {
        return IntStream.concat(stream1, stream2)
                .filter(x -> x % 3 == 0 || x % 5 == 0)
                .sorted()
                .skip(2);
    }

    // another option using Predicate
    Predicate<Integer> isDividedBy3 = num -> num % 3 == 0;
    Predicate<Integer> isDividedBy5 = num -> num % 5 == 0;
    Predicate<Integer> isDividedBy3And5 = isDividedBy3.or(isDividedBy5);

    public IntStream combine2(IntStream stream1, IntStream stream2) {
        return IntStream.concat(stream1, stream2)
                .filter((IntPredicate) isDividedBy3And5)
                .sorted()
                .skip(2);
    }

}
