package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

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

}
