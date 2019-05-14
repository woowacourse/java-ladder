package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
    static List<Integer> split(final String input) {
        if (input.equals("")) {
            return null;
        }

        return getIntegers(input.split("[,:]+"));
    }

    static List<Integer> customSplit(final String input) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(input);
        if (m.find()) {
            String customDelimiter = m.group(1);
            String[] tokens = m.group(2).split(customDelimiter);

            return getIntegers(tokens);
        }

        return null;
    }

    private static List<Integer> getIntegers(String[] input) {
        List<Integer> nums = new ArrayList<>();

        for (String s : input) {
            nums.add(Integer.parseInt(s));
        }
        return nums;
    }
}
