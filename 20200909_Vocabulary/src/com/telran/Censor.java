package com.telran;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Censor {

    private Set<String> vocabulary;

    public Censor(Set<String> vocabulary) {
        this.vocabulary = vocabulary
                .stream()
                .map(String::toLowerCase)
                .collect(Collectors.toSet());
    }

    public List<String> findBadWords(String text) {
        return Arrays.stream(text.split(" "))
                .map(input -> input.toLowerCase())
                .filter(word -> vocabulary.contains(word))
                .collect(Collectors.toList());
    }
}
