package view;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class InputView {

    public static List<String> readNames(Supplier<String> input) {
        String inputString = input.get();
        validateEmpty(inputString);
        return Arrays.stream(inputString.split(","))
                .toList();
    }

    private static void validateEmpty(String inputString) {
        if (inputString == null || inputString.isBlank()) {
            throw new IllegalArgumentException("null 혹은 비 문자열을 입력할 수 없습니다.");
        }
    }
}
