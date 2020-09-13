package com.telran;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class CensorTest {

    Set<String> vocabulary = new HashSet<>();
    Censor censor;

    @BeforeEach
    public void init(){
        vocabulary.add("list");
        vocabulary.add("set");
        vocabulary.add("deque");
        vocabulary.add("treemap");

        censor = new Censor(vocabulary);
    }

    @Test
    public void testCensor_zeroMatches() {

        String text = "sjfjs hfjsd lkuyb";
        List<String> expected = Arrays.asList();
        assertEquals(expected, censor.findBadWords(text));
    }

    @Test
    public void testCensor_3matches() {

        String text = "sjfjs List hfjsd sEt deque lkuyb";
        List<String> expected = Arrays.asList("list", "set", "deque");
        assertEquals(expected, censor.findBadWords(text));
    }

    @Test
    public void testCensor_allMatches() {

        String text = "sjfjs list list hfjsd set deque lkuyb treemap";
        List<String> expected = Arrays.asList("list", "list", "set", "deque", "treemap");
        assertEquals(expected, censor.findBadWords(text));
    }
}