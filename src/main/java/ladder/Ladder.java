package ladder;

import java.util.Arrays;
import java.util.List;

public class Ladder {
    private static final String REGEX_OF_NUMBER = "[1-9][0-9]*";

    public static List<String> splitNames(String names) {
        return Arrays.asList(names.split(","));
    }

    public static boolean checkNameLength(String name) {
        return name.length() <= 5;
    }

    public static boolean checkLadderHeight(String height) {
        return height.matches(REGEX_OF_NUMBER);
    }
}
