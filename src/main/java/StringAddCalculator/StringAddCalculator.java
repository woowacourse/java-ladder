package StringAddCalculator;

import java.util.ArrayList;
import java.util.List;

public class StringAddCalculator {
    private static final int USER_SPLITTER_INDEX = 2;
    private static final int LOWER_BOUND_EXPRESSION = 4;

    static List<Integer> splitString(String input, List<String> splitter) {
        input = getExpression(Validator.checkEmpty(input), splitter);

        return convertStringToInt(replaceSplitter(input.trim(), splitter).split(" "));
    }

    private static String getExpression(String input, List<String> splitter) {
        if (Validator.matchCustomSplitter(input)) {
            splitter.add(Character.toString(input.charAt(USER_SPLITTER_INDEX)));
            return input.substring(LOWER_BOUND_EXPRESSION);
        }

        return input;
    }

    private static String replaceSplitter(String input, List<String> splitter) {
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
            int num = Validator.checkNegativeValue(Integer.parseInt(value));
            result.add(num);
        }

        return result;
    }


}
