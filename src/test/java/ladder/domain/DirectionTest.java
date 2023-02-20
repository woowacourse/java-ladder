package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class DirectionTest {

    @Test
    @DisplayName("방향에 따라 이동할 특정 값을 가진다.")
    void directionHasMoveValue() {
        final List<Integer> moves = Arrays.stream(Direction.values())
                .map(Direction::getMove)
                .collect(Collectors.toList());

        assertThat(moves).containsExactly(-1, 0, 1);
    }

    @ParameterizedTest(name = "입력: {0}")
    @ValueSource(ints = {-2, 2})
    @DisplayName("존재하지 않는 값이라면 예외를 던진다.")
    void throwExceptionNotExistValue(final int value) {
        assertThatThrownBy(() -> Direction.from(value))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("유효하지 않은 값입니다.");
    }
}
