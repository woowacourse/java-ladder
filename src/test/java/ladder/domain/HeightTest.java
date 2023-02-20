package ladder.domain;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.text.MessageFormat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class HeightTest {

    @ParameterizedTest(name = "입력: {0}")
    @ValueSource(ints = {1, 11})
    @DisplayName("높이가 2미만, 10초과이면 예외를 던진다.")
    void checkInvalidHeight(final int value) {
        assertThatThrownBy(() -> new Height(value))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(MessageFormat.format("높이는 2이상, 10이하여야 합니다. 현재 높이는 {0}입니다.", value));
    }

    @ParameterizedTest(name = "입력: {0}")
    @ValueSource(ints = {2, 10})
    @DisplayName("높이는 2이상, 10이하여야 한다.")
    void checkValidHeight(final int value) {
        assertThatNoException().isThrownBy(() -> new Height(value));
    }
}
