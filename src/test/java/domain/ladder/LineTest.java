package domain.ladder;

import static org.assertj.core.api.Assertions.assertThat;

import domain.player.Name;
import domain.player.Player;
import domain.player.Position;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LineTest {

    @DisplayName("좌측 이동이 가능하면 true를 반환한다.")
    @Test
    void left_passable_true() {
        // given
        Position position = new Position(2);
        Player player = new Player(new Name("name"), position);
        Line line = new Line(List.of(LinePoint.PASSABLE, LinePoint.BLOCKED));
        // when
        boolean result = line.isLeftSidePassable(player);
        // then
        assertThat(result).isTrue();

    }
    @DisplayName("position이 좌측 끝이면 좌측 이동이 불가능하다..")
    @Test
    void left_passable_false_by_left_end() {
        // given
        Position position = new Position(1);
        Line line = new Line(List.of(LinePoint.PASSABLE, LinePoint.BLOCKED));
        Player player = new Player(new Name("name"), position);

        // when
        boolean result = line.isLeftSidePassable(player);
        // then
        assertThat(result).isFalse();
    }

    @DisplayName("좌측 point가 block이라면 좌측 이동이 불가능하다.")
    @Test
    void left_passable_false_by_left_point_block() {
        // given
        Position position = new Position(2);
        Line line = new Line(List.of(LinePoint.BLOCKED, LinePoint.PASSABLE));
        Player player = new Player(new Name("name"), position);
        // when
        boolean result = line.isLeftSidePassable(player);
        // then
        assertThat(result).isFalse();
    }

    @DisplayName("우측 이동이 가능하면 true를 반환한다.")
    @Test
    void right_passable_true() {
        // given
        Position position = new Position(2);
        Line line = new Line(List.of(LinePoint.BLOCKED, LinePoint.PASSABLE));
        Player player = new Player(new Name("name"), position);

        // when
        boolean result = line.isRightSidePassable(player);
        // then
        assertThat(result).isTrue();
    }

    @DisplayName("position이 우측 끝이면 우측 이동이 불가능하다.")
    @Test
    void right_passable_false_by_right_end() {
        // given
        Position position = new Position(3);
        Line line = new Line(List.of(LinePoint.PASSABLE, LinePoint.BLOCKED));
        Player player = new Player(new Name("name"), position);
        // when
        boolean result = line.isRightSidePassable(player);
        // then
        assertThat(result).isFalse();
    }

    @DisplayName("우측 point가 block이라면 우측 이동이 불가능하다.")
    @Test
    void right_passable_false_by_right_point_block() {
        // given
        Position position = new Position(2);
        Line line = new Line(List.of(LinePoint.PASSABLE, LinePoint.BLOCKED));
        Player player = new Player(new Name("name"), position);
        // when
        boolean result = line.isRightSidePassable(player);
        // then
        assertThat(result).isFalse();
    }
}
