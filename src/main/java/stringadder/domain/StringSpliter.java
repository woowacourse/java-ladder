package stringadder.domain;

import java.util.Arrays;
import java.util.List;

public class StringSpliter {
    public static List<String> splitBySeparators(String numbersWithSeparator, List<String> separators) {
        String separatorsToRex = String.join("|", separators);

        return Arrays.asList(numbersWithSeparator.split(separatorsToRex));
    }
}
