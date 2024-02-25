package domain;

import static domain.ExceptionType.POSITION_OVERFLOW;

import java.util.List;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class PositionTest {

    static Stream<Arguments> nextParameter() {
        return Stream.of(
                Arguments.of(0, 1),
                Arguments.of(1, 0)
        );
    }

    @Test
    @DisplayName("최대 위치 값 이하만 생성되는지 검증")
    void validateMax() {
        Assertions.assertThatThrownBy(() -> Position.getCachedPosition(3, 2))
                .isInstanceOf(LadderGameException.class)
                .hasMessage(POSITION_OVERFLOW.getMessage());
    }

    @Test
    @DisplayName("최소 위치 값 이상만 생성되는지 검증")
    void validateMin() {
        Assertions.assertThatThrownBy(() -> Position.getCachedPosition(-1, 2))
                .isInstanceOf(LadderGameException.class)
                .hasMessage(POSITION_OVERFLOW.getMessage());
    }

    @ParameterizedTest
    @MethodSource("nextParameter")
    @DisplayName("다음 위치 검증")
    void next(int rawPosition, int rawExpectedNextPosition) {
        Position position = Position.getCachedPosition(rawPosition, 1);
        Position actual = position.move(List.of(true));
        Position expected = Position.getCachedPosition(rawExpectedNextPosition, 1);
        Assertions.assertThat(actual)
                .isEqualTo(expected);
    }
}
