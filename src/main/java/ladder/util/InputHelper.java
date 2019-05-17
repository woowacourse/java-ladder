package ladder.util;

import java.util.Arrays;
import java.util.List;

public class InputHelper {
    private static final String SPLITTER = ",";

    public static List<String> splitNames(String inputs) {
        return Arrays.asList(inputs.split(SPLITTER));
    }
}
