package calculator;

import java.util.ArrayList;
import java.util.List;

public class Numbers {
    public static List<Integer> parseIntegerList(String[] values) {
        List<Integer> numbers = new ArrayList<>();

        for (String value : values) {
            addNumber(numbers, value);
        }
        return numbers;
    }

    private static void addNumber(List<Integer> numbers, String value) {
        numbers.add(checkNumber(value));
    }

    private static int checkNumber(String value) {
        int number = parseStringToInt(value);
        validatePositiveNumber(number);

        return number;
    }

    private static void validatePositiveNumber(int value) {
        if (value < 0) {
            throw new RuntimeException("음수입니다.");
        }
    }

    private static int parseStringToInt(String value) {
        int num;
        try {
            num = Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new RuntimeException("문자가 포함되었습니다.");
        }
        return num;
    }
}
