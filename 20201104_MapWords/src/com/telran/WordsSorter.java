package com.telran;

import java.util.*;
import java.util.stream.Collectors;

public class WordsSorter {

    public static void main(String[] args) {
        List<String> words = Arrays.asList("abc", "bac", "cab", "acb", "bca", "cba", "aa", "bc", "cc", "b");
        System.out.println(getWords(words));

        System.out.println(anotherWay(words));
    }

    // works good
    public static Map<Character, List<String>> getWords(List<String> words) {

        return words.stream()
                .sorted()
                .collect(Collectors.groupingBy(word -> word.charAt(0)));
    }

    // returns non-sorted list
    public static Map<Character, List<String>> anotherWay(List<String> words) {
        Map<Character, List<String>> map = new HashMap<>();

        for (String word : words) {
            Character firstLetter = word.charAt(0);

            if (map.get(firstLetter) == null) {
                map.put(firstLetter, new ArrayList<>(Collections.singletonList(word)));
            } else {
                map.get(firstLetter).add(word);
            }
        }

        return map;
    }

//            if (map.get(firstLetter) == null) {
//                List< String> listToSort = new ArrayList<>(Collections.singletonList(word));
//                List<String> sorted = listToSort.stream().sorted().collect(Collectors.toList());
//                map.put(firstLetter, sorted);
//            } else
//                map.get(firstLetter).add(word);

}
