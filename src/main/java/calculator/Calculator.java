package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Calculator {
    static List<Integer> split(final String input) {
        if (input.equals("")) {
            return null;
        }

        return getIntegers(input);
    }

    private static List<Integer> getIntegers(String input) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(input);
        if (m.find()) {
            return convertInputsToIntegers(m.group(2).split(m.group(1)));
        }
        return convertInputsToIntegers(input.split("[,:]+"));
    }

    private static List<Integer> convertInputsToIntegers(String[] input) {
        return Arrays.asList(input).stream().
                map(Integer::parseInt).collect(Collectors.toList());
    }

    public static int add(String s) {
        List<Integer> nums = split(s);
        if (hasNegativeInteger(nums)) {
            throw new IllegalArgumentException();
        }
        return getSum(nums);
    }

    private static boolean hasNegativeInteger(List<Integer> nums) {
        return nums.stream().filter(n -> n < 0).collect(Collectors.toList()).size() != 0;
    }

    private static int getSum(List<Integer> nums) {
        return nums.stream().mapToInt(Integer::intValue).sum();
    }
}
