package textcalculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TextCalculatorTest {
    private TextCalculator textCalculator;

    @BeforeEach
    void set(){
        textCalculator = new TextCalculator();
    }

    @Test
    void 쉼표_구분() {
        String inputString = "1,2,3"; // [1,2,3]
        List<String> tokens =  textCalculator.tokenizer(inputString);
        assertEquals(Arrays.asList("1","2","3"), tokens);
    }
}