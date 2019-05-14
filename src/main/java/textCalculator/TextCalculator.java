package textCalculator;

import java.util.Arrays;
import java.util.List;

public class TextCalculator {

    private static final String DEFAULT_DELIMITERS = ",:";

    public int calculate(String text) {
        List<String> tokens = Arrays.asList(text.split(getDelimiterSet()));
        return getResult(tokens);
    }

    private String getDelimiterSet() {
        return Arrays.asList(DEFAULT_DELIMITERS.split(""))
                .toString()
                .replaceAll(", ", "");
    }

    private int getResult(List<String> tokens) {
        return tokens.stream().mapToInt(token -> Integer.parseInt(token)).sum();
    }
}
