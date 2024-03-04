package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class DirectionTest {

    @ParameterizedTest
    @CsvSource(value = {"LEFT, -1", "RIGHT, 1", "CENTER, 0"})
    @DisplayName("이동 방향에 따른 값을 얻을 수 있다.")
    void getValue(Direction direction, int expected) {
        int actual = direction.getValue();
        assertThat(actual).isEqualTo(expected);
    }
}
