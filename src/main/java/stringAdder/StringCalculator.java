package stringAdder;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    private static final int INIT_SUM = 0;
    private static final String DEFAULT_DELIMITER = ",|:";
    private static final String CUSTOM_DELIMITER_PATTON = "//(.)\n(.*)";

    public static int addAll(String string) {
        if (isBlank(string)) {
            return 0;
        }

        return sum(Numbers.toInts(parseStrings(string)));
    }

    private static boolean isBlank(String string) {
        return string == null || string.isEmpty();
    }

    private static int sum(int[] numbers) {
        int sum = INIT_SUM;

        for (int value : numbers) {
            sum += value;
        }

        return sum;
    }

    private static String[] parseStrings(String text) {
        Matcher m = Pattern.compile(CUSTOM_DELIMITER_PATTON).matcher(text);

        if (m.find()) {
            String customDelimiter = m.group(1);
            String[] tokens = m.group(2).split(customDelimiter);

            return tokens;
        }

        return text.split(DEFAULT_DELIMITER);
    }


}
