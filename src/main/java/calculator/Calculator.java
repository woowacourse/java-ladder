package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

class Calculator {
    static int add(String s) {
        List<Positive> nums = split(s);
        return getSum(nums);
    }

    static List<Positive> split(final String input) {
        if (input.equals("")) {
            return null;
        }

        return getIntegers(input);
    }

    private static List<Positive> getIntegers(String input) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(input);
        if (m.find()) {
            return convertInputsToIntegers(m.group(2).split(m.group(1)));
        }
        return convertInputsToIntegers(input.split("[,:]+"));
    }

    private static List<Positive> convertInputsToIntegers(String[] input) {
        return Arrays.stream(input)
                .map(s -> new Positive(Integer.parseInt(s)))
                .collect(Collectors.toList());
    }

    private static int getSum(List<Positive> nums) {
        return nums.stream().mapToInt(Positive::getNumber).sum();
    }
}
