package StringAddCalculator;

import java.util.Arrays;
import java.util.List;

public class Validator {
    static String checkEmpty(String input) {
        if (input.length() == 0) {
            input = "0";
        }
        return input;
    }

    static boolean checkLastIndex(char lastValue, String[] splitter) {
        List<String> splitters = Arrays.asList(splitter);
        return splitters.contains(Character.toString(lastValue));
    }
}
