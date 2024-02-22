package validator;

import java.util.regex.Pattern;

public class PlayersInputValidator {
    private static final String DEFAULT_DELIMITER = ",";
    private static final Pattern VALID_DELIMITER_PATTERN = Pattern.compile(
            "^[a-zA-Z가-힣\\d]+(" + DEFAULT_DELIMITER + "[a-zA-Z가-힣\\d]+)*$");
    private static final String INVALID_SPECIAL_CHARACTER_EXCEPTION_MESSAGE = "[ERROR] 쉼표 이외의 특수문자는 입력할 수 없습니다.";

    private PlayersInputValidator() {
    }

    public static void validate(String input) {
        InputValidator.validateBlank(input);
        InputValidator.validateContainsSpace(input);
        validatePattern(input);
    }

    public static void validatePattern(String input) {
        if (!VALID_DELIMITER_PATTERN.matcher(input).matches()) {
            throw new IllegalArgumentException(INVALID_SPECIAL_CHARACTER_EXCEPTION_MESSAGE);
        }
    }
}
