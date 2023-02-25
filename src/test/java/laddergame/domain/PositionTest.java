package laddergame.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import laddergame.utils.LineMaker;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("유저의 위치는 ")
class PositionTest {

    @DisplayName("사용자의 위치는 0보다 작을 수 없다.")
    @ParameterizedTest
    @ValueSource(ints = {-1, -2, -10})
    void smaller_than_0(int pos) {
        int userCount = 5;

        assertThrows(IllegalArgumentException.class, () -> new Position(pos, userCount));
    }

    @DisplayName("총 유저 수보다 작아야 한다.")
    @ParameterizedTest
    @ValueSource(ints = {5, 6, 7})
    void bigger_than_userCount(int pos) {
        int userCount = 5;

        assertThrows(IllegalArgumentException.class, () -> new Position(pos, userCount));
    }

    @DisplayName("0 이상, 사용자 수 미만이어야 한다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 4})
    void position_success(int pos) {
        int userCount = 5;

        assertDoesNotThrow(() -> {
            new Position(pos, userCount);
        });
    }

    @DisplayName("오른쪽으로 이동 시 위치가 1 증가한다.")
    @Test
    void move_right_success() {
        //given
        int initialPosition = 0;
        int userCount = 5;
        Position position = new Position(initialPosition, userCount);

        LineMaker lineMaker = new FixedLineMaker();
        Line line = new Line(lineMaker, userCount);
        //when
        int movedPosition = position.moveByConnectionStatus(line);

        //then
        Assertions.assertThat(movedPosition).isEqualTo(initialPosition + 1);
    }

    @DisplayName("왼쪽으로 이동 시 위치가 1 증가한다.")
    @Test
    void move_left_success() {
        //given
        int initialPosition = 3;
        int userCount = 5;
        Position position = new Position(initialPosition, userCount);

        LineMaker lineMaker = new FixedLineMaker();
        Line line = new Line(lineMaker, userCount);
        //when
        int movedPosition = position.moveByConnectionStatus(line);

        //then
        Assertions.assertThat(movedPosition).isEqualTo(initialPosition - 1);
    }

    private class FixedLineMaker implements LineMaker {

        @Override
        public List<Point> generateLine(int userCount) {
            return List.of(new Point(true)
                    , new Point(false)
                    , new Point(true)
                    , new Point(false));
        }
    }
}
