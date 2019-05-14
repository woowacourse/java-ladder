package calculator;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;

public class Calculator {

    public static List<String> inputSplit(String input) {
        if (StringUtils.isBlank(input)) {
            return Arrays.asList("0");
        }
        if (input.charAt(0) == '/') {
            return customSplitNumbers(input);
        }
        return Arrays.asList(input.split(",|:"));
    }

    public static List<String> customSplitNumbers(String input) {
        String removeSlash = input.replace("//", "");
        String[] s = removeSlash.split("\n");
        return Arrays.asList(s[1].split(s[0]));
    }
}
