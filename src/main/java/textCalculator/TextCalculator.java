package textCalculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextCalculator {
    private static final String DEFAULT_DELIMITERS = ",:";
    private static final String FORBIDDEN_DELIMITERS = "-";
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
        String numbers = extractCustomDelimiters(text);
        Pattern pattern = Pattern.compile(Pattern.quote(getSplitDelimiter()));
        return Arrays.asList(pattern.split(numbers));
    }

    private String extractCustomDelimiters(String text) {
        Matcher m = Pattern.compile("//(.*)\n(.*)").matcher(text);
        if (m.find()) {
            delimiters.addAll(Arrays.asList((m.group(1)).split("")));
            delimiters.stream().forEach(x -> validateOnlyAllowedDelimiters(x));
            return m.group(2);
        }
        return text;
    }

    private void validateOnlyAllowedDelimiters(String delimiter) {
        if (delimiter.equals(FORBIDDEN_DELIMITERS)) {
            throw new IllegalArgumentException();
        }
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
