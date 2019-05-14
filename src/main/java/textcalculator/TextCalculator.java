package textcalculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TextCalculator {
    public List<String> tokenizer(String inputString) {
        return Arrays.asList(inputString.split(","));
    }

    public List<Integer> toInt(List<String> tokens) {
        List<Integer> numbers = new ArrayList<>();
        for (String token : tokens) {
            numbers.add(Integer.parseInt(token));
        }
        return numbers;
    }
}
