package domain.player;

import static org.assertj.core.api.Assertions.assertThat;

import domain.ladder.Line;
import domain.ladder.LinePoint;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PositionTest {

    @DisplayName("좌측 이동이 가능하면 true를 반환한다.")
    @Test
    void left_passable_true() {
        // given
        Position position = new Position(2);
        Line line = new Line(List.of(LinePoint.PASSABLE, LinePoint.BLOCKED));

        // when
        boolean result = position.isLeftSidePassable(line);

        // then
        assertThat(result).isTrue();
    }

    @DisplayName("position이 좌측 끝이면 좌측 이동이 불가능하다.")
    @Test
    void left_passable_false_by_left_end() {
        // given
        Position position = new Position(1);
        Line line = new Line(List.of(LinePoint.PASSABLE, LinePoint.BLOCKED));

        // when
        boolean result = position.isLeftSidePassable(line);

        // then
        assertThat(result).isFalse();
    }

    @DisplayName("좌측 point가 block이라면 좌측 이동이 불가능하다.")
    @Test
    void left_passable_false_by_left_point_block() {
        // given
        Position position = new Position(2);
        Line line = new Line(List.of(LinePoint.BLOCKED, LinePoint.PASSABLE));

        // when
        boolean result = position.isLeftSidePassable(line);

        // then
        assertThat(result).isFalse();
    }

    @DisplayName("우측 이동이 가능하면 true를 반환한다.")
    @Test
    void right_passable_true() {
        // given
        Position position = new Position(2);
        Line line = new Line(List.of(LinePoint.BLOCKED, LinePoint.PASSABLE));

        // when
        boolean result = position.isRightSidePassable(line);

        // then
        assertThat(result).isTrue();
    }

    @DisplayName("position이 우측 끝이면 우측 이동이 불가능하다.")
    @Test
    void right_passable_false_by_right_end() {
        // given
        Position position = new Position(3);
        Line line = new Line(List.of(LinePoint.PASSABLE, LinePoint.BLOCKED));

        // when
        boolean result = position.isRightSidePassable(line);

        // then
        assertThat(result).isFalse();
    }

    @DisplayName("우측 point가 block이라면 우측 이동이 불가능하다.")
    @Test
    void right_passable_false_by_right_point_block() {
        // given
        Position position = new Position(2);
        Line line = new Line(List.of(LinePoint.PASSABLE, LinePoint.BLOCKED));

        // when
        boolean result = position.isRightSidePassable(line);

        // then
        assertThat(result).isFalse();
    }

    @DisplayName("moveLeft를 하면 Position 내부의 값이 1 감소한다.")
    @Test
    void move_left_value_minus_one() {
        // given
        Position position = new Position(2);

        // when
        position.moveLeft();

        // then
        assertThat(position.getPosition()).isEqualTo(1);
    }

    @DisplayName("moveRight를 하면 Position 내부의 값이 1 증가한다.")
    @Test
    void move_right_value_plus_one() {
        // given
        Position position = new Position(2);

        // when
        position.moveRight();

        // then
        assertThat(position.getPosition()).isEqualTo(3);
    }
}
