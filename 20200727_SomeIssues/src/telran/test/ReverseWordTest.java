package telran.test;


import org.junit.Assert;
import org.junit.Test;
import telran.data.Main;

import static org.junit.jupiter.api.Assertions.*;

public class ReverseWordTest {

    @Test
    public void reverseWordTest1() {
        String input = "string";
        String actual = Main.reverseWord(input);
        String expected = "gnirts";

        assertEquals(expected, actual);
    }

}
