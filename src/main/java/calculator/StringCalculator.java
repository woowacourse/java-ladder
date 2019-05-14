package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    public int process(String input) {
        if (isNull(input) || input.isEmpty()) return 0;

        String[] tokens = getTokens(input);

        validate(tokens);

        return getSum(tokens);
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

    private int getSum(String[] tokens) {
        int sum = 0;

        for (String token : tokens) {
            sum += Integer.parseInt(token);
        }

        return sum;
    }

    private void validateNegativeNumber(String token) {
        if (Integer.parseInt(token) < 0) {
            throw new RuntimeException("0 이상의 정수를 입력해 주세요.");
        }
    }

    private void validateInteger(String token) {
        if (!(new Integer(Integer.parseInt(token)) instanceof Integer)) {
            throw new RuntimeException("구분자와 숫자만을 입력해주세요..");
        }
    }

    private boolean isNull(String input) {
        return input == null;
    }
}
