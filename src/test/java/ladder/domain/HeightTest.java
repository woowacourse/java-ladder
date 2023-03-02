package ladder.domain;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class HeightTest {

    @ParameterizedTest(name = "높이: {0}")
    @ValueSource(ints = {1, 11})
    @DisplayName("높이가 2미만, 10초과라면 예외를 던진다.")
    void throw_exception_invalid_height(final int value) {
        assertThatThrownBy(() -> new Height(value))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("높이는 2이상, 10이하여야 합니다. 현재 높이는 " + value + "입니다.");
    }

    @ParameterizedTest(name = "높이: {0}")
    @ValueSource(ints = {2, 5, 10})
    @DisplayName("높이는 2이상, 10이하여야 한다.")
    void should_val값id_height(final int value) {
        assertThatNoException().isThrownBy(() -> new Height(value));
    }
}
