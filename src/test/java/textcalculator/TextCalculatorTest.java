package textcalculator;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class TextCalculatorTest {
    private TextCalculator textCalculator;

    @Before
    public void set(){
        textCalculator = new TextCalculator();
    }

    @Test
    public void 쉼표_구분() {
        String inputString = "1,2,3"; // [1,2,3]
        List<String> tokens =  textCalculator.tokenizer(inputString);
        assertEquals(Arrays.asList("1","2","3"), tokens);
    }

    @Test
    public void 숫자_변환() {
        List<String> tokens = Arrays.asList("1", "2", "3");
        List<Integer> numbers = textCalculator.toInt(tokens);
        assertEquals(Arrays.asList(1, 2, 3), numbers);

    }

    @Test(expected = IllegalArgumentException.class)
    public void 토큰이_문자인_경우() {
        textCalculator.toInt(Arrays.asList("1","2","a"));

    }

    @Test(expected = IllegalArgumentException.class)
    public void 토큰이_음수인_경우() {
        textCalculator.toInt(Arrays.asList("-1","2","3"));
    }
}