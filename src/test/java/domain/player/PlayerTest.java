package domain.player;

import static domain.ladder.LinePoint.BLOCKED;
import static domain.ladder.LinePoint.PASSABLE;
import static org.assertj.core.api.Assertions.assertThat;

import domain.ladder.Line;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayerTest {

    @DisplayName("이름이 같으면 true를 반환한다.")
    @Test
    void same_name_return_true() {
        // given
        Name name = new Name("name");
        Player player = new Player(name, new Position(1));
        // then
        assertThat(player.isSameName("name")).isTrue();
    }

    @DisplayName("이름이 다르면 false를 반환한다.")
    @Test
    void different_name_return_false() {
        // given
        Name name = new Name("name");
        Player player = new Player(name, new Position(1));
        // then
        assertThat(player.isSameName("differentName")).isFalse();
    }

    private List<Line> createLine() {
        return List.of(
                new Line(List.of(PASSABLE, BLOCKED, PASSABLE, BLOCKED)),
                new Line(List.of(BLOCKED, PASSABLE, BLOCKED, PASSABLE)),
                new Line(List.of(BLOCKED, PASSABLE, BLOCKED, PASSABLE)),
                new Line(List.of(BLOCKED, PASSABLE, BLOCKED, PASSABLE)));
    }
}
