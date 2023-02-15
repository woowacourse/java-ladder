package ladder.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringSplitter {

    private static final String NULL_MESSAGE = "null이 입력되면 안됩니다";

    private StringSplitter() {
    }


    public static List<String> split(String input, String seperator) {
        validateInput(input);

        return Arrays.stream(input.split(seperator)).collect(Collectors.toList());
    }

    private static void validateInput(String input) {
        if (input == null) {
            throw new IllegalArgumentException(NULL_MESSAGE);
        }
    }
}
