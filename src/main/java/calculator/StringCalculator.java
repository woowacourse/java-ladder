package calculator;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    private static final int INITIAL_SUM = 0;
    private static final int NEGATIVE_CRITERION = 0;

    public int process(String input) {
        if (Objects.isNull(input) || input.isEmpty()) return 0;

        String[] tokens = getTokens(input);

        validate(tokens);

        return sum(tokens);
    }

    private String[] getTokens(String input) {
        String delimiters = ",:";
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(input);

        if (m.find()) {
            delimiters += m.group(1);
            return m.group(2).split("[" + delimiters + "]");
        }
        return input.split("[" + delimiters + "]");
    }

    private void validate(String[] tokens) {
        for (String token : tokens) {
            validateInteger(token);
            validateNegativeNumber(token);
        }
    }

    private int sum(String[] tokens) {
        int sum = INITIAL_SUM;

        for (String token : tokens) {
            sum += Integer.parseInt(token);
        }

        return sum;
    }

    private void validateNegativeNumber(String token) {
        if (Integer.parseInt(token) < NEGATIVE_CRITERION) {
            throw new RuntimeException("0 이상의 정수를 입력해 주세요.");
        }
    }

    private void validateInteger(String token) {
        if (!(new Integer(Integer.parseInt(token)) instanceof Integer)) {
            throw new RuntimeException("구분자와 숫자만을 입력해주세요..");
        }
    }
}
