package laddergame.util;

public class InputValidator {
    public static void validateBlank(final String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 입력값에 빈값을 입력할 수 없습니다.");
        }
    }
}
