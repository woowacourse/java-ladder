package ladder.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.*;

class CommonValidatorTest {
    @ParameterizedTest(name = "input : {0}")
    @NullAndEmptySource
    @DisplayName("입력 값이 Null 또는 blank 인 경우 예외처리")
    void test_1(String input) {
        // then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> CommonValidator.validateBlank(input))
                .withMessage("빈 값을 입력할 수 없습니다.");
    }
}
