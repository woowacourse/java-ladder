package calculator;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
    public static List<Integer> getNumbers(String input) {
        List<Integer> result = new ArrayList<>();
        for (String s : inputSplit(input)) {
            result.add(Integer.parseInt(s));
        }
        return result;
    }

    public static List<String> inputSplit(String input) {
        if (StringUtils.isBlank(input)) {
            return Arrays.asList("0");
        }
        if (input.charAt(0) == '/') {
            return customSplit(input);
        }
        return Arrays.asList(input.split(",|:"));
    }

    public static List<String> customSplit(String input) {
        Matcher matcher = Pattern.compile("//(.*)\\\\n(.*)").matcher(input);
        if (matcher.find()) {
            String custom = matcher.group(1);
            return Arrays.asList(matcher.group(2).split(custom));
        }

        throw new IllegalArgumentException("입력값이 잘못되었습니다.");
    }
}
