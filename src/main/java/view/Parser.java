package view;

import java.util.Arrays;
import java.util.List;

public class Parser {
    private static final String DELIMITER = ",";

    private Parser() {
    }

    public static List<String> split(String input) {
        validateInput(input);
        return Arrays.asList(input.split(DELIMITER));
    }

    private static void validateInput(String input) {
        if (input.endsWith(DELIMITER)) {
            throw new IllegalArgumentException("입력은 콤마(,)로 마칠 수 없습니다.");
        }
    }

    public static int parseHeight(String input) {
        return Integer.parseInt(input);
    }
}
