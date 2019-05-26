package calculator;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
    private static final String REGEX_OF_DEFAULT_SEPARATOR = ",|:";
    private static final String REGEX_OF_INPUT_FORMAT = "//(.)\n(.*)";
    private static final String REGEX_OF_NUMBER = "[0-9]+";

    public static String[] splitString(String input) {
        if (StringUtils.isBlank(input)) {
            return new String[]{};
        }
        return splitStringWithSeparator(input);
    }

    private static String[] splitStringWithSeparator(String input) {
        Pattern pattern = Pattern.compile(REGEX_OF_INPUT_FORMAT);
        Matcher m = pattern.matcher(input.replaceAll("\\\\n", "\n"));

        if (m.find()) {
            String customDelimiter = m.group(1);
            String newRegex = Pattern.quote(customDelimiter) + "|" + REGEX_OF_DEFAULT_SEPARATOR;
            return m.group(2).split(newRegex);
        }

        return input.split(REGEX_OF_DEFAULT_SEPARATOR);
    }

    public static int sumValues(String[] values) {
        return Arrays.stream(values).mapToInt(value -> Integer.parseInt(value)).sum();
    }

    public static void checkCorrectValue(String[] values) {
        if (!Arrays.stream(values).allMatch(value -> value.matches(REGEX_OF_NUMBER))) {
            throw new RuntimeException();
        }
    }
}
