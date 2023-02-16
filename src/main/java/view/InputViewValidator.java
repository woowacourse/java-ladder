package view;

public class InputViewValidator {

    public static void validatePlayerNames(String input) {
        validateNotEmpty(input);
    }

    public static void validateLadderHeight(String input) {
        validateNotEmpty(input);
        validateNotInteger(input);
    }

    private static void validateNotEmpty(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException("입력값이 비어있습니다.");
        }
    }

    public static void validateNotInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("사다리 높이는 숫자만 입력할 수 있습니다.");
        }
    }
}
