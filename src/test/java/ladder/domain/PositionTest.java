package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class PositionTest {

    @DisplayName("방향에 따라 위치의 값이 변한다")
    @ParameterizedTest
    @CsvSource(value = {"LEFT:1", "RIGHT:3", "NONE:2"}, delimiter = ':')
    void shouldPositionIsChangedWhenMoveByDirection(Direction direction, int expectPosition) {
        //given
        Position position = new Position(2);
        //when
        position.move(direction);
        //then
        assertThat(position).isEqualTo(new Position(expectPosition));
    }
}
