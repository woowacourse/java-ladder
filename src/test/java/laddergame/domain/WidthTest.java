package laddergame.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import laddergame.domain.ladder.Width;
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

    @DisplayName("게터로 가져온 값이 생성 시 넣은 값과 일치한다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4})
    void getValue(int value) {
        Width width = new Width(value);
        assertThat(width.getValue()).isEqualTo(value);
    }
}
