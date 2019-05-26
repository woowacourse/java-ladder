package StringAddCalculator;

import java.util.List;
import java.util.regex.Pattern;

public class Validator {
    static String checkEmpty(String input) {
        if (input == null || input.length() == 0) {
            input = "0";
        }
        return input;
    }

    static boolean checkLastIndex(char lastValue, List<String> splitters) {
        return splitters.contains(Character.toString(lastValue));
    }

    static boolean matchCustomSplitter(String input) {
        Pattern pattern = Pattern.compile("//.*\\n.*");
        return pattern.matcher(input).matches();
    }

    static int checkNegativeValue(int number) {
        if (number < 0) {
            throw new RuntimeException();
        }
        return number;
    }
}
