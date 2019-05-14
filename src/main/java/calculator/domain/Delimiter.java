package calculator.domain;

import calculator.constants.Constants;

public class Delimiter {
    public static String getFromString(String input) {
        String processedInput = getCustomDelimiter(input);
        if (processedInput != null) return processedInput;
        return Constants.DEFAULT_DELIMITER;
    }

    private static String getCustomDelimiter(String input) {
        if (input.substring(0, 2).equals(Constants.CUSTOM_START_IDENTIFIER)) {
            String[] processedInput = input.split(Constants.CUSTOM_END_IDENTIFIER);
            return processedInput[0].replace(Constants.CUSTOM_START_IDENTIFIER, "");
        }
        return null;
    }
}
