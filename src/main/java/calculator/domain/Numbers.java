package calculator.domain;

import calculator.constants.Constants;

import java.util.ArrayList;
import java.util.List;

public class Numbers {
    public static List<Integer> getFromString(String input, String delimiter) {
        List<Integer> numbers = new ArrayList<>();
        String expression = processingInput(input, delimiter);
        String[] stringNumbers = expression.split(delimiter);
        for (int i = 0; i < stringNumbers.length ; i++) {
            numbers.add(toValidInteger(stringNumbers[i]));
        }
        return numbers;
    }

    private static Integer toValidInteger(String stringNumber) {
        int number = Integer.parseInt(stringNumber);
        if (number < 0) {
            throw new RuntimeException("음수는 입력이 불가합니다.");
        }
        return Integer.valueOf(stringNumber);
    }

    private static String processingInput(String input, String delimiter) {
        String expression = input;
        if(!delimiter.equals(Constants.DEFAULT_DELIMITER)){
            String[] processedInput = input.split(Constants.CUSTOM_END_IDENTIFIER);
            expression = processedInput[1];
        }
        return expression;
    }
}
