package calculator;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
    public static final String FORMAT_SYMBOL = "//(.*)\\\\n(.*)";
    public static final String DEFAULT_SYMBOL = ",|:";
    public static final String STRING_ZERO = "0";
    public static final Character SLASH = '/';
    public static final int ZERO = 0;

    public static List<Integer> convertNumbers(String input) {
        input = StringUtils.deleteWhitespace(input);
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
            String splitSymbol = matcher.group(1);
            String content = matcher.group(2);
            return Arrays.asList(content.split(Pattern.quote(splitSymbol)));
        }
        throw new IllegalArgumentException("입력값이 잘못되었습니다.");
    }

    static int checkMinusNumber(int number) {
        if (number < ZERO) {
            throw new IllegalArgumentException("음수가 포함되어 있습니다.");
        }
        return number;
    }

    public static int sumNumber(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(x -> x)
                .sum();
    }
}
