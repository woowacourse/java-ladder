package ladder.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class DirectionTest {

    @ParameterizedTest(name = "값: {0}")
    @ValueSource(ints = {-2, 2})
    @DisplayName("방향이 존재하지 않는 값이라면 예외를 던진다.")
    void throw_exception_invalid_value(final int value) {
        assertThatThrownBy(() -> Direction.from(value))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("유효하지 않은 값입니다.");
    }
}
