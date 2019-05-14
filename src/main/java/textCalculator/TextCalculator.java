package textCalculator;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextCalculator {

    private static final String DEFAULT_DELIMITERS = ",:";

    public int calculate(String text) {
        String customDelimiters = "";
        Matcher m = Pattern.compile("//(.*)\n(.*)").matcher(text);
        if (m.find()) {
            customDelimiters += m.group(1);
            text = m.group(2);
        }
        List<String> tokens = Arrays.asList(text.split(getDelimiterSet(customDelimiters)));
        return getResult(tokens);
    }

    private String getDelimiterSet(String customDelimiters) {
        return Arrays.asList((DEFAULT_DELIMITERS + customDelimiters).split(""))
                .toString()
                .replaceAll(", ", "");
    }

    private int getResult(List<String> tokens) {
        return tokens.stream().mapToInt(token -> Integer.parseInt(token)).sum();
    }
}
