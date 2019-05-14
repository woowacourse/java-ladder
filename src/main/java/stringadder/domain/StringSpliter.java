package stringadder.domain;

import java.util.Arrays;
import java.util.List;

public class StringSpliter {
    private static final String CUSTOM_SEPARATOR_PICKER = "//|\n";
    private static final int NUMBER_STRING_POSITION = 2;

    static List<String> splitBySeparators(String numbersWithSeparator, List<String> separators) {
        String separatorsToRex = String.join("|", separators);

        return Arrays.asList(numbersWithSeparator.split(separatorsToRex));
    }

    static String splitToNumberString(String input) {
        return input.split(CUSTOM_SEPARATOR_PICKER)[NUMBER_STRING_POSITION];
    }
}
