package textCalculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextCalculator {
    private static final String DEFAULT_DELIMITERS = ",:";
    private List<String> delimiters;

    public TextCalculator() {
        delimiters = new ArrayList<>(Arrays.asList((DEFAULT_DELIMITERS).split("")));
    }

    public int calculate(String text) {
        return getResult(tokenCorrector(textTokenizer(textCorrector(text))));
    }

    private int getResult(List<String> tokens) {
        return tokens.stream().mapToInt(token -> getNonNegativeInteger(token)).sum();
    }

    private int getNonNegativeInteger(String token) {
        int integer = Integer.parseInt(token);
        if (integer < 0) {
            throw new IllegalArgumentException();
        }
        return integer;
    }

    private List<String> tokenCorrector(List<String> tokens) {
        for (String token : tokens) {
            if (token.isEmpty()) {
                return Arrays.asList("0");
            }
        }
        return tokens;
    }

    private List<String> textTokenizer(String text) {
        return Arrays.asList(extractCustomDelimiters(text).split(getSplitDelimiter()));
    }

    private String extractCustomDelimiters(String text) {
        Matcher m = Pattern.compile("//(.*)\n(.*)").matcher(text);
        if (m.find()) {
            delimiters.addAll(Arrays.asList((m.group(1)).split("")));
            return m.group(2);
        }
        return text;
    }

    private String getSplitDelimiter() {
        return delimiters.toString().replaceAll(", ", "");
    }

    private String textCorrector(String text) {
        if (text == null) {
            return "0";
        }
        return text;
    }
}
