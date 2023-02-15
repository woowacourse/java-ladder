package ladder.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringSplitter {

    private StringSplitter() {
    }

    public static List<String> split(String input, String delimiter) {
        validateInput(input);
        return Arrays.stream(input.split(delimiter)).collect(Collectors.toList());
    }

    private static void validateInput(String input) {
        if (input == null) {
            throw new IllegalArgumentException("null 이 입력되면 안 됩니다");
        }
    }
}
