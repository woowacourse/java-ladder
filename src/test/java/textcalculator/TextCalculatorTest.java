package textcalculator;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TextCalculatorTest {
    private TextCalculator textCalculator;

    @Before
    public void set() {
        textCalculator = new TextCalculator();
    }

    @Test
    public void 쉼표_구분() {
        String inputString = "1,2,3"; // [1,2,3]
        List<String> tokens = textCalculator.tokenizer(inputString);
        assertEquals(Arrays.asList("1", "2", "3"), tokens);
    }

    @Test
    public void 숫자_변환() {
        List<String> tokens = Arrays.asList("1", "2", "3");
        List<Integer> numbers = textCalculator.toInt(tokens);
        assertEquals(Arrays.asList(1, 2, 3), numbers);

    }

    @Test(expected = IllegalArgumentException.class)
    public void 토큰이_문자인_경우() {
        textCalculator.toInt(Arrays.asList("1", "2", "a"));

    }

    @Test(expected = IllegalArgumentException.class)
    public void 토큰이_음수인_경우() {
        textCalculator.toInt(Arrays.asList("-1", "2", "3"));
    }

    @Test
    public void 토큰의_합() {
        assertEquals(6, textCalculator.sum(Arrays.asList(1, 2, 3)));
    }

    @Test
    public void 쉼표_또는_콜론_구분() {
        String inputString = "1,2:3"; // [1,2,3]
        List<String> tokens = textCalculator.tokenizer(inputString);
        assertEquals(Arrays.asList("1", "2", "3"), tokens);
    }

    @Test
    public void 쉼표_또는_콜론_합계() {
        String inputString = "1,2:3";
        assertEquals(6, textCalculator.sum(textCalculator.toInt(textCalculator.tokenizer(inputString))));
    }


}