package textcalculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TextCalculator {
    public List<String> tokenizer(String inputString) {
        return Arrays.asList(inputString.split(","));
    }

    public List<Integer> toInt(List<String> tokens) {
        return tokens.stream().map(Integer::valueOf).collect(Collectors.toList());
    }
}
