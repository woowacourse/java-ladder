package textcalculator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TextCalculator {
    public List<String> tokenizer(String inputString) {
        return Arrays.asList(inputString.split(",|:"));
    }

    public List<Integer> toInt(List<String> tokens) {
        return tokens.stream().map((str) -> {
            if (Integer.parseInt(str) < 0) {
                throw new IllegalArgumentException();
            }
            return Integer.parseInt(str);
        }).collect(Collectors.toList());
    }

    public int sum(List<Integer> numbers) {
        return numbers.stream().mapToInt(number -> number).sum();
    }
}
