package domain.ladder;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import domain.player.Name;
import domain.player.Player;
import domain.player.Position;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LineTest {

    @DisplayName("객체를 정상적으로 생성한다.")
    @Test
    void create_success() {
        // given
        List<LinePoint> points = List.of(
                new LinePoint(Direction.RIGHT, new Position(1)),
                new LinePoint(Direction.LEFT, new Position(2)));
        // then
        assertThatNoException().isThrownBy(() -> new Line(points));
    }

    @DisplayName("중복된 위치가 존재하면 예외를 반환한다.")
    @Test
    void create_fail_by_duplicate_position() {
        // given
        List<LinePoint> points = List.of(
                new LinePoint(Direction.RIGHT, new Position(1)),
                new LinePoint(Direction.LEFT, new Position(1)));
        // then
        assertThatThrownBy(() -> new Line(points))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("중복된 위치가 존재합니다.");
    }

    @DisplayName("좌측 이동이 가능하면 Position을 1 감소 시킨다.")
    @Test
    void left_move_decrease_position_one() {
        // given
        Player player = new Player(new Name("name"), new Position(2));
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
        Player player = new Player(new Name("name"), new Position(1));
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
        Player player = new Player(new Name("name"), new Position(1));
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
