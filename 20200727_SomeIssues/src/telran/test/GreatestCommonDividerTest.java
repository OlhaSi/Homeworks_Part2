package telran.test;

import org.junit.Assert;
import org.junit.Test;
import telran.data.Main;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GreatestCommonDividerTest {

    @Test
    public void greatestCommonDividerTest1 (){
        int actual = Main.findGreatestCommonDivider(6,9);
        int expected = 3;

        assertEquals(expected, actual);
    }

    @Test
    public void greatestCommonDividerTest2 (){
        int actual = Main.findGreatestCommonDivider(4,8);
        int expected = 4;

        assertEquals(expected, actual);
        Assert.assertNotNull(actual);
    }
}
