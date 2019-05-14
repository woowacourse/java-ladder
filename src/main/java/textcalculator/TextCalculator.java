package textcalculator;

import java.util.Arrays;
import java.util.List;

public class TextCalculator {
    public List<String> tokenizer(String inputString) {
        return Arrays.asList(inputString.split(","));
    }
}
