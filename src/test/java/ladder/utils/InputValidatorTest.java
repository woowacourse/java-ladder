package ladder.utils;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputValidatorTest {
    @Test
    void 입력값의_길이_체크() {
        assertThatThrownBy(() -> InputValidator.isWrongLength("pooooooobi,deeeeeenis")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 음수_또는_0_체크() {
        assertThatThrownBy(() -> InputValidator.checkPositive(0)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> InputValidator.checkPositive(-1)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 중복된_이름_체크() {
        assertThatThrownBy(() -> InputValidator.checkValidNames("pobi,pobi")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 이름으로_받지_말아야_할_값_체크(){
        assertThatThrownBy(()-> InputValidator.checkValidNames("all")).isInstanceOf(IllegalArgumentException.class);
    }
}
