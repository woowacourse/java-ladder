package textCalculator;

import java.util.Arrays;
import java.util.List;

public class TextCalculator {

    public int calculate(String text) {
        String delimiter = ",";
        List<String> tokens = Arrays.asList(text.split(delimiter));
        return getResult(tokens);
    }

    private int getResult(List<String> tokens) {
        return tokens.stream().mapToInt(token -> Integer.parseInt(token)).sum();
    }
}
