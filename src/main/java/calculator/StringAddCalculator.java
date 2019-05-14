package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final String DEFAULT_DELIMITER = ",|:";

    int add(String text) {
        if (isTextEmpty(text)) {
            return 0;
        }
        Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(text);
        String delimiter = DEFAULT_DELIMITER;

        return getSum(getTexts(matcher, delimiter, text));
    }

    private String[] getTexts(Matcher matcher, String delimiter, String text) {
        if (matcher.find()) {
            delimiter = matcher.group(1);
            text = matcher.group(2);
        }

        return text.split(delimiter);
    }

    private boolean isTextEmpty(String text) {
        return text == null || text.isEmpty();
    }

    private int getSum(String[] texts) {
        int sum = 0;
        for (String number : texts) {
            sum += Integer.parseInt(number);
        }

        return sum;
    }
}
