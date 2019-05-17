package calculator;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    public static int addValues(String inputText) {
        if (isBlank(inputText)) {
            return 0;
        }
        return sum(Numbers.parseIntegerList(splitDelimiter(inputText)));
    }

    private static boolean isBlank(String string) {
        return string == null || string.isEmpty();
    }

    private static int sum(List<Integer> numbers) {
        int sum = 0;

        for (int number : numbers) {
            sum += number;
        }
        return sum;
    }

    private static String[] splitDelimiter(String inputText) {
        Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(inputText);
        String[] values = splitCustomDelimiter(matcher);

        if (values != null) {
            return values;
        }
        return inputText.split(",|:");
    }

    private static String[] splitCustomDelimiter(Matcher matcher) {
        if (matcher.find()) {
            return matcher.group(2).split(matcher.group(1));
        }
        return null;
    }
}
