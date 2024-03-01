package view;

import java.util.Arrays;
import java.util.List;

public class Parser {
    private static final String DELIMITER = ",";
    private static final String INVALID_INPUT = "입력은 쉼표(,)로 끝날 수 없습니다.";

    private Parser() {
    }

    public static List<String> splitInputValue(String input) {
        validateInput(input);
        return Arrays.asList(input.split(DELIMITER));
    }

    private static void validateInput(String input) {
        if (input.endsWith(DELIMITER)) {
            throw new IllegalArgumentException(INVALID_INPUT);
        }
    }

    public static int parseHeight(String input) {
        return Integer.parseInt(input);
    }
}
