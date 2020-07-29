package telran.test;

import org.junit.Test;
import telran.data.Main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GetRepeatedTest {

    @Test
    public void getRepeatedTest1 (){
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 2, 3, 1, 2, 3, 4));
        List<Integer> actual = Main.getRepeated(input);
        List<Integer> expected = Arrays.asList(1,2,3);

        assertEquals(expected, actual);
    }

    @Test
    public void getRepeatedTest2 (){
        List<Integer> input = new ArrayList<>(Arrays.asList(1));
        List<Integer> actual = Main.getRepeated(input);
        List<Integer> expected = Arrays.asList();

        assertEquals(expected, actual);
    }

    @Test
    public void getRepeatedTest3 (){
        List<Integer> input = new ArrayList<>(Arrays.asList(1,1,1,1));
        List<Integer> actual = Main.getRepeated(input);
        List<Integer> expected = Arrays.asList(1);

        assertEquals(expected, actual);
    }
}
