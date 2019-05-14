package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Calculator {
    static List<Integer> split(final String input) {
        if (input.equals("")) {
            return null;
        }

        return getIntegers(input);
    }

    private static List<Integer> getIntegers(String input) {
        List<Integer> nums = new ArrayList<>();

        for (String s : Arrays.asList(input.split("[,:]+"))) {
            nums.add(Integer.parseInt(s));
        }
        return nums;
    }
}
