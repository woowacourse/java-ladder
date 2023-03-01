package domain.ladder;

import static org.assertj.core.api.Assertions.assertThat;

import domain.player.Name;
import domain.player.Player;
import domain.player.Position;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LineTest {

    @DisplayName("좌측 이동이 가능하면 Position을 1 감소 시킨다.")
    @Test
    void left_move_decrease_position_one() {
        // given
        Position position = new Position(2);
        Player player = new Player(new Name("name"), position);
        List<LinePoint> points = List.of(
                new LinePoint(Direction.RIGHT, new Position(1)),
                new LinePoint(Direction.LEFT, new Position(2)));
        Line line = new Line(points);
        // when
        line.move(player);
        Position actualPosition = player.getPosition();
        // then
        assertThat(actualPosition).isEqualTo(new Position(1));
    }

    @DisplayName("우측 이동이 가능하면 Position을 1 증가 시킨다.")
    @Test
    void right_move_increase_position_one() {
        // given
        Position position = new Position(1);
        Player player = new Player(new Name("name"), position);
        List<LinePoint> points = List.of(
                new LinePoint(Direction.RIGHT, new Position(1)),
                new LinePoint(Direction.LEFT, new Position(2)));
        Line line = new Line(points);
        // when
        line.move(player);
        Position actualPosition = player.getPosition();
        // then
        assertThat(actualPosition).isEqualTo(new Position(2));
    }

    @DisplayName("아래로 이동하면 Position이 변화하지 않는다 시킨다.")
    @Test
    void down_move_not_change_position() {
        // given
        Position position = new Position(1);
        Player player = new Player(new Name("name"), position);
        List<LinePoint> points = List.of(
                new LinePoint(Direction.DOWN, new Position(1)),
                new LinePoint(Direction.RIGHT, new Position(2)));
        Line line = new Line(points);
        // when
        line.move(player);
        Position actualPosition = player.getPosition();
        // then
        assertThat(actualPosition).isEqualTo(new Position(1));
    }
}
