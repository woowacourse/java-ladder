package ladder.validator;

import java.util.Objects;

public class CommonValidator {
    public static void validate(String input) {
        validateBlank(input);
    }

    private static void validateBlank(String input) {
        if (Objects.isNull(input) || input.isBlank()) {
            throw new IllegalArgumentException("빈 값을 입력할 수 없습니다.");
        }
    }
}
