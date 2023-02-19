package domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LineStateTest {
    @DisplayName("값이 1인경우 상태값은 true이다.")
    @Test
    void value_1_true() {
        boolean result = LineState.of(1).getState();
        assertThat(result).isTrue();
    }

    @DisplayName("값이 0인 경우 상태값은 false이다.")
    @Test
    void value_2_false() {
        boolean result = LineState.of(0).getState();
        assertThat(result).isFalse();
    }

    @DisplayName("값이 0과 1이 아닌 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {-1,2})
    void value_else_Excpetion(int value) {
        assertThatThrownBy(() -> LineState.of(value).getState())
                .isInstanceOf(IllegalArgumentException.class);
    }

}
