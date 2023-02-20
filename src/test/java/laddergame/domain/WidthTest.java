package laddergame.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class WidthTest {
    @DisplayName("값이 양수가 아니면 예외를 던진다.")
    @ParameterizedTest
    @ValueSource(ints = {0, -1, -2})
    void create(int value) {
        assertThatThrownBy(() -> new Width(value))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
