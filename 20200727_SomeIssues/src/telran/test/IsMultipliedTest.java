package telran.test;

import org.junit.Test;
import telran.data.Main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class IsMultipliedTest {

    @Test
    public void IsMultipliedTest1() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3, 5, 7, 8, 10));
        boolean actual = Main.isMultiplied(input, 5);

        assertTrue(actual);
    }

    @Test
    public void IsMultipliedTest2() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3, 5, 7, 8, 10));
        boolean actual = Main.isMultiplied(input, 2);

        assertFalse(actual);
    }
}
