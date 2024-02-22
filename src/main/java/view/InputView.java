package view;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class InputView {

    public static List<String> readNames(Supplier<String> input) {
        String inputString = input.get();
        validateEmpty(inputString);
        validateEndedWithComma(inputString);
        return Arrays.stream(inputString.split(","))
                .peek(InputView::validateEmpty)
                .map(String::trim)
                .toList();
    }

    private static void validateEmpty(String inputString) {
        if (inputString == null || inputString.isBlank()) {
            throw new IllegalArgumentException("null 혹은 빈 문자열을 입력할 수 없습니다.");
        }
    }

    private static void validateEndedWithComma(String inputString) {
        if (inputString.endsWith(",")){
            throw new IllegalArgumentException("null 혹은 빈 문자열을 입력할 수 없습니다.");
        }
    }

    public static int readHeight(Supplier<String> input) {
        String inputString = input.get();
        validateEmpty(inputString);
        validateInteger(inputString);
        return Integer.parseInt(inputString);
    }

    private static void validateInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("정수를 입력해야 합니다.");
        }
    }
}
