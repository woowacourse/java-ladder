package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    private static final String BETWEEN_REMARK_AND_NEXT_LINE = "//(.)\n(.*)";
    private static final String COMMA_OR_COLON = "[,:]";

    public int add(String text) {
        if (isBlank(text)) return 0;

        return sum(toInts(split(text)));
    }

    private boolean isBlank(String text) {
        return text == null || text.isEmpty();
    }

    private String[] split(String text) {
        Matcher m = Pattern.compile(BETWEEN_REMARK_AND_NEXT_LINE).matcher(text);

        if (m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }

        return text.split(COMMA_OR_COLON);
    }

    private List<Integer> toInts(String[] values) {
        List<Integer> numbers = new ArrayList<>();

        for (String value : values) {
            int number = Integer.parseInt(value);
            checkNegativeNumber(number);
            numbers.add(number);
        }

        return numbers;
    }

    private void checkNegativeNumber(int number) {
        if (number < 0) {
            throw new IllegalStateException();
        }
    }

    private int sum(List<Integer> numbers) {
        int sum = 0;
        for (Integer number : numbers) {
            sum += number;
        }
        return sum;
    }
}
