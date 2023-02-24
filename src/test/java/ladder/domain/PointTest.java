package ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


class PointTest {

    Point point;

    @BeforeEach
    void makePoint() {
        point = new Point(2);
    }

    @Test
    @DisplayName("아래로 내려가는 동작이 제대로 일어나는지 테스트")
    void validMoveVertical() {
        // when
        point.moveVertical();

        // then
        Assertions.assertThat(point.getVerticalPosition()).isEqualTo(1);
    }

    @ParameterizedTest
    @CsvSource(value = {"-1:1", "0:2", "1:3"}, delimiter = ':')
    @DisplayName("왼쪽으로 이동, 가만히 있는지, 오른쪽으로 이동하는지 테스트")
    void validMoveHorizontal(int directionValue, int expected) {
        // given
        Direction direction = Direction.from(directionValue);

        // when
        point.moveHorizontal(direction);

        // then
        Assertions.assertThat(point.getHorizontalPosition()).isEqualTo(expected);
    }
}
