package calculator;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

    private static final String FORMAT_SYMBOL = "//(.*)\\\\n(.*)";
    private static final String DEFAULT_SYMBOL = ",|:";
    private static final String STRING_ZERO = "0";
    private static final Character SLASH = '0';
    private static final int ZERO = 0;

    public static List<Integer> convertNumber(String input) {
        input = input.replaceAll(" ", "");
        List<Integer> result = new ArrayList<>();
        for (String s : inputSplit(input)) {
            result.add(checkMinusNumber(Integer.parseInt(s)));
        }
        return result;
    }

    public static List<String> inputSplit(String input) {
        if (StringUtils.isBlank(input)) {
            return Arrays.asList(STRING_ZERO);
        }
        if (input.charAt(0) == SLASH) {
            return customSplit(input);
        }
        return Arrays.asList(input.split(DEFAULT_SYMBOL));
    }

    public static List<String> customSplit(String input) {
        Matcher matcher = Pattern.compile(FORMAT_SYMBOL).matcher(input);
        if (matcher.find()) {
            return Arrays.asList(matcher.group(2).split(Pattern.quote(matcher.group(1))));
        }
        throw new IllegalArgumentException("입력값이 잘못되었습니다.");
    }

    static int checkMinusNumber(int number) {
        if (number < ZERO) {
            throw new IllegalArgumentException("음수가 포함되어 있습니다.");
        }
        return number;
    }

    public static int calSumNumber(List<Integer> numbers) {
        return numbers.stream().reduce(0, (x, y) -> x + y);
    }
}
