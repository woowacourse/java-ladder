package validator;

public class HeightInputValidator {
    private static final String NUMERIC_EXCEPTION_MESSAGE = "[ERROR] 숫자만 입력할 수 있습니다.";

    private HeightInputValidator() {
    }

    public static void validate(String input) {
        InputValidator.validateBlank(input);
        InputValidator.validateContainsSpace(input);
        validateNumeric(input);
    }

    private static void validateNumeric(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NUMERIC_EXCEPTION_MESSAGE);
        }
    }
}
