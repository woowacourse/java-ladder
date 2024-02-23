package validator;

public class InputValidator {
    private static final String BLANK_EXCEPTION_MESSAGE = "[ERROR] 빈 값은 입력할 수 없습니다.";
    private static final String SPACE_EXCEPTION_MESSAGE = "[ERROR] 공백은 포함될 수 없습니다.";

    private InputValidator() {
    }

    public static void validateBlank(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException(BLANK_EXCEPTION_MESSAGE);
        }
    }

    public static void validateContainsSpace(String input) {
        if (input.contains(" ")) {
            throw new IllegalArgumentException(SPACE_EXCEPTION_MESSAGE);
        }
    }
}
