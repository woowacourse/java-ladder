package calculator;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringSumCalculator {
    private static final int CUSTOM = 1;
    private static final int CALCULATE_SENTENCE = 2;

    public int calculateFormula(String formula) {
        if (StringUtils.isBlank(formula)) {
            return 0;
        }
        return sum(split(formula));
    }

    private String[] split(String formula) {
        Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(formula);

        if (matcher.find()) {
            return matcher.group(CALCULATE_SENTENCE).split(matcher.group(CUSTOM));
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
            throw new RuntimeException("음수는 입력될 수 없습니다!");
        }
        return num;
    }
}
