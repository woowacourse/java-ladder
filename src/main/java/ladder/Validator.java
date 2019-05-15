package ladder;

import java.util.List;

public class Validator {
    private static final String REGEX_OF_NUMBER = "[1-9][0-9]*";

    public static boolean checkNameLength(String name) {
        return name.length() <= 5;
    }

    public static boolean checkNamesLength(List<String> names) {
        boolean result = true;

        for (String name : names) {
            result = result && checkNameLength(name);
        }

        return result;
    }

    public static boolean checkLadderHeight(String height) {
        return height.matches(REGEX_OF_NUMBER);
    }
}
