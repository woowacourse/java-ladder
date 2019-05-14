package StringAddCalculator;

import java.util.ArrayList;
import java.util.List;

public class StringAddCalculator {
    static List<Integer> splitString(String input, String[] splitter) {
        input = Validator.checkEmpty(input);
        return convertStringToInt(replaceSplitter(input.trim(), splitter).split(" "));
    }

    private static String replaceSplitter(String input, String[] splitter) {
        if (Validator.checkLastIndex(input.charAt(input.length() - 1), splitter)) {
            throw new IllegalArgumentException();
        }
        for (String s : splitter) {
            input = input.replaceAll(s, " ");
        }
        return input;
    }

    private static List<Integer> convertStringToInt(String[] splitValues) {
        List<Integer> result = new ArrayList<>();
        for (String value : splitValues) {
            result.add(Integer.parseInt(value));
        }

        return result;
    }


}
