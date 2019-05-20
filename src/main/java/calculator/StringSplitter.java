package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringSplitter {
    private static final String CUSTOM_DELIMITER_REGEX = "//(.)\n(.*)";
    private static final String DEFAULT_DELIMITER = ",|;";

    static String[] split(String numbers) {
        Matcher m = Pattern.compile(CUSTOM_DELIMITER_REGEX).matcher(numbers);

        return m.find() ? splitCustom(m) : splitDefault(numbers);
    }

    private static String[] splitDefault(String numbers) {
        return numbers.split(DEFAULT_DELIMITER);
    }

    private static String[] splitCustom(Matcher m) {
        String customDelimiter = m.group(1);
        String numbers = m.group(2);
        return numbers.split(Pattern.quote(customDelimiter));
    }
}
