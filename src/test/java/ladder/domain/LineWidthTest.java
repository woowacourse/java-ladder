package ladder.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LineWidthTest {

    @ParameterizedTest
    @ValueSource(ints = {-1, 0})
    @DisplayName("사다리 라인 폭이 1 미만이면 예외를 던진다.")
    void should_ThrowException_When_ValueLessThan1(int value) {
        assertThatThrownBy(() -> new LineWidth(value))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("사다리 폭은 1 이상이어야 합니다.");
    }
}
