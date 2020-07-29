package telran.test;

import org.junit.Assert;
import org.junit.Test;
import telran.data.Main;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FindSquareTest {

    @Test
    public void findSquareTest1() {
        int actual = Main.findSquare(5);
        int expected = 25;

        assertEquals(expected, actual);
    }

    @Test
    public void findSquareTest2() {
        int actual = Main.findSquare(5);
        int expected = 25;

        Assert.assertNotNull(actual);
        assertEquals(expected, actual);
    }

    @Test
    public void findSquareTest3() {
        int actual = Main.findSquare(0);
        int expected = 0;

        assertEquals(expected, actual);
    }
}
