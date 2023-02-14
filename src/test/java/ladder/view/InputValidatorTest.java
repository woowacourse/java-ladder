package ladder.view;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputValidatorTest {

    @Test
    void 문자열이_입력되면_예외_발생() {
        String input = "abc";
        assertThatThrownBy(() -> InputValidator.validateInteger(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 정수가_입력되면_정상_통과() {
        String input = "3";
        assertThatCode(() -> InputValidator.validateInteger(input))
                .doesNotThrowAnyException();
    }
}
