package view;

import java.util.Arrays;
import java.util.List;

public class Parser {
    private static final String DELIMITER = ",";

    private Parser() {
    }

    public static List<String> splitName(String input) {
        validateInput(input);
        return Arrays.asList(input.split(DELIMITER));
    }

    private static void validateInput(String input) {
        if (input.endsWith(DELIMITER)) {
            throw new IllegalArgumentException();
        }
    }

    public static int parseHeight(String input) {
        return Integer.parseInt(input);
    }
}
