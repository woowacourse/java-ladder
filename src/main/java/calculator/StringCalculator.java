package calculator;


import org.apache.commons.lang3.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    private final String COMMA = ",";
    private final String COLON = ":";
    private final String COL_LINE ="|";
    public int add(String text) {
        if (StringUtils.isBlank(text)) return 0;

        return sum(toInts(split(text)));
    }

    private String[] split(String text) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (m.find()) {
            String customDelimeter = m.group(1);
            return m.group(2).split(customDelimeter);
        }
        return text.split(COMMA+COL_LINE+COLON);
    }

    private int[] toInts(String[] values) {
        int[] numbers = new int[values.length];
        for (int i = 0; i < values.length; i++) {
            int number = Integer.parseInt(values[i]);
            numbers[i] = checkNegativeNumber(number);
        }
        return numbers;
    }

    private int checkNegativeNumber(int number) {
        if (number < 0) {
            throw new RuntimeException();
        }
        return number;
    }

    private int sum(int[] numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return sum;
    }
}
