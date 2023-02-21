package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class DirectionTest {

    @ParameterizedTest
    @CsvSource(value = {"LEFT:-1", "RIGHT:1", "NONE:0"}, delimiter = ':')
    @DisplayName("방향에 따라 다른 값을 반환한다")
    void shouldReturnValueWhenGetDirection(Direction direction, int expect) {
        assertThat(direction.getMoveValue()).isEqualTo(expect);
    }

    @ParameterizedTest
    @CsvSource(value = {"true:false:LEFT", "false:true:RIGHT", "false:false:NONE"}, delimiter = ':')
    @DisplayName("bar의 유무에 따라 방향을 반환한다")
    void shouldReturnDirectionWhenBarExist(boolean isLeftExist, boolean isRightExist, Direction expect) {
        //given
        //when
        Direction direction = Direction.of(isLeftExist, isRightExist);
        //then
        Assertions.assertThat(direction).isEqualTo(expect);
    }

}
