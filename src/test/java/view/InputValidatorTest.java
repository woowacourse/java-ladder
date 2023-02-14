package view;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputValidatorTest {
    @ParameterizedTest(name = "{0}이 입력값일 때 IllegalArgumentException이 발생한다")
    @DisplayName("사다리 높이는 정수가 아닐 때 예외를 반환한다")
    @ValueSource(strings = {"3.3", "Sun"})
    void ladderHeightNonInteger(String height) {
        InputValidator inputValidator = new InputValidator();
        Assertions.assertThrows(IllegalArgumentException.class, () -> inputValidator.validateHeight(height));
    }
}
