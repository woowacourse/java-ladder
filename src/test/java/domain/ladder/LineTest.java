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
        List<LinePoint> points = List.of(new LinePoint(Direction.RIGHT, new Position(1)),
                new LinePoint(Direction.LEFT, new Position(2)));
        Line line = new Line(points);

        // when
        line.move(player);
        int actualPosition = player.getPosition();
        // then
        assertThat(actualPosition).isEqualTo(1);

    }

}
