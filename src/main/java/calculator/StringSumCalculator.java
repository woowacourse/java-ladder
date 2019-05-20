package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringSumCalculator {
    public int calculateFormula(String formula) {
        if (isBlank(formula)) {
            return 0;
        }
        return sum(split(formula));
    }

    private boolean isBlank(String formula) {
        return formula == null || formula.isEmpty();
    }

    private String[] split(String formula) {
        Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(formula);

        if (matcher.find()) {
            return matcher.group(2).split(matcher.group(1));
        }
        return formula.split("[,:]");
    }

    private int sum(String[] result) {
        return Arrays.stream(result)
                .mapToInt(this::parsePositive)
                .sum();
    }

    private int parsePositive(String number) {
        int num = Integer.parseInt(number);

        if (num < 0) {
            throw new RuntimeException();
        }
        return num;
    }
}
