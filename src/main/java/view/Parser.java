package view;

import java.util.Arrays;
import java.util.List;

public class Parser {
    private static final String DELIMITER = ",";

    public static List<String> splitName(String input) {
        return Arrays.asList(input.split(DELIMITER));
    }

    public static int parseHeight(String input) {
        return Integer.parseInt(input);
    }
}
