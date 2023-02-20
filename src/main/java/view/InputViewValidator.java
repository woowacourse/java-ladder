package view;

public class InputViewValidator {

    public static void validatePlayerNames(final String input) {
        validateNotEmpty(input);
    }

    public static void validateLadderHeight(final String input) {
        validateNotEmpty(input);
        validateNotInteger(input);
    }

    private static void validateNotEmpty(final String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException("입력값이 비어있습니다.");
        }
    }

    public static void validateNotInteger(final String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("사다리 높이는 숫자만 입력할 수 있습니다.");
        }
    }

}
