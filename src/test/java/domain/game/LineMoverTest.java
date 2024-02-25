package domain.game;

import domain.ladder.Bridge;
import domain.ladder.Line;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LineMoverTest {

    @Test
    @DisplayName("한 줄을 정상적으로 이동시키는가")
    void move_single_line_correctly() {
        Line line = new Line(3, () -> Bridge.EXIST);
        List<Integer> players = List.of(1, 2, 3, 4);

        LineMover lineMover = new LineMover(line, players);

        List<Integer> expected = List.of(2, 1, 4, 3);
        assertThat(lineMover.getResult()).containsExactlyElementsOf(expected);
    }

    @Test
    @DisplayName("다리가 없는 경우에 이동이 없는가")
    void no_movement_when_any_bridge_exist() {
        Line line = new Line(3, () -> Bridge.EMPTY);
        List<Integer> players = List.of(1, 2, 3, 4);

        LineMover lineMover = new LineMover(line, players);

        assertThat(lineMover.getResult()).containsExactlyElementsOf(players);
    }

}
