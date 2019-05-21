package ladder.util;

import java.util.Arrays;
import java.util.List;

public class InputHelper {
    private static final String SPLITTER = ",";
    private static final String ALL = "all";

    public static List<String> splitNames(String inputs) {
        return Arrays.asList(inputs.split(SPLITTER));
    }

    public static boolean isAll(String input) {
        return input.equals(ALL);
    }
}
