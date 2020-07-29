package telran.test;

import org.junit.Test;
import telran.data.Main;

import static org.junit.jupiter.api.Assertions.*;

public class ChangeCaseTest {

    @Test
    public void changeCaseTest1 (){
        String input = "Hello";
        String actual = Main.changeCase(input);
        String expected = "hELLO";

        assertEquals(expected, actual);
    }

    @Test
    public void changeCaseTest2 (){
        String input = "H";
        String actual = Main.changeCase(input);
        String expected = "h";

        assertEquals(expected, actual);
    }
}
