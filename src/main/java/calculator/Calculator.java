package calculator;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

    public static List<Integer> getNumbers(String input) {
        input = StringUtils.deleteWhitespace(input);
        List<Integer> result = new ArrayList<>();
        for (String s : inputSplit(input)) {
            result.add(checkMinusNumber(Integer.parseInt(s)));
        }
        return result;
    }

    public static List<String> inputSplit(String input) {
        if (StringUtils.isBlank(input)) {
            return Arrays.asList(CalculatorConst.STRING_ZERO);
        }
        if (input.charAt(0) == CalculatorConst.SLASH) {
            return customSplit(input);
        }
        return Arrays.asList(input.split(CalculatorConst.DEFAULT_SYMBOL));
    }

    public static List<String> customSplit(String input) {
        Matcher matcher = Pattern.compile(CalculatorConst.FORMAT_SYMBOL).matcher(input);
        if (matcher.find()) {
            return Arrays.asList(matcher.group(2).split(Pattern.quote(matcher.group(1))));
        }
        throw new IllegalArgumentException("입력값이 잘못되었습니다.");
    }

    static int checkMinusNumber(int number) {
        if (number < CalculatorConst.ZERO) {
            throw new IllegalArgumentException("음수가 포함되어 있습니다.");
        }
        return number;
    }

    public static int calSumNumber(List<Integer> numbers) {
        return numbers.stream().reduce(0, (x, y) -> x + y);
    }
}
