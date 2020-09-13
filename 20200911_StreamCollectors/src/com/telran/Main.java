package com.telran;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        //Stream<Integer> stream = Stream.of(3, 5, 2, 9);
        IntStream stream = IntStream.of(3, 5, 2, 9);

        // count sum of squares of numbers from stream
        stream.mapToObj(value -> Integer.valueOf(value))
                .collect(Collectors.summingInt(value -> value * value));

        // count multiplication of squares of numbers from stream
        int res = stream.mapToObj(value -> Integer.valueOf(value))
                .collect(Collectors.reducing(1, ((currentRes, elt) -> currentRes * elt * elt)));


        // partitioning a stream of Strings onto the list of palindromes and others
        Stream<String> streamString = Stream.of("aba", "acb", "abc", "aabb");

        Predicate<String> isPalindrome = Main::isPalindrome;
        Map<Boolean, List<String>> isStringPalindrome = streamString
                .collect(Collectors.partitioningBy(isPalindrome));
    }

    public static boolean isPalindrome(String input) {
        return new StringBuilder(input)
                .reverse()
                .toString()
                .equals(input);
    }
}
