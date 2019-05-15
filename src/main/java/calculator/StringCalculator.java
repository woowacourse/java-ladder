package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    public int input(String formula) {
        if (formula == null || formula.isEmpty()) {
            return 0;
        }

        String[] result = split(formula);

        return Arrays.stream(result)
                .mapToInt(Integer::parseInt)
                .sum();
    }

    private String[] split(String formula) {
        Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(formula);

        if (matcher.find()) {
            return matcher.group(2).split(matcher.group(1));
        }
        return formula.split("[,:]");
    }
}
