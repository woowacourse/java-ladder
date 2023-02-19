package ladder.validator;

import java.util.Objects;

public class CommonValidator {
    private CommonValidator() { }
    
    public static void validateBlank(String input) {
        if (Objects.isNull(input) || input.isBlank()) {
            throw new IllegalArgumentException("빈 값을 입력할 수 없습니다.");
        }
    }
}
