package domain.game;

import domain.TestBridgeMakingStrategy;
import domain.ladder.Row;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static domain.ladder.Bridge.EMPTY;
import static domain.ladder.Bridge.EXIST;
import static org.assertj.core.api.Assertions.assertThat;

class LadderClimberTest {

    @Test
    @DisplayName("한 줄을 정상적으로 이동시키는가")
    void move_single_line_correctly() {
        TestBridgeMakingStrategy strategy = new TestBridgeMakingStrategy(
                List.of(EXIST, EMPTY, EXIST, EMPTY));

        Row row = new Row(3, strategy);
        List<Integer> players = List.of(0, 1, 2, 3);

        List<Integer> actual = LadderClimber.climbDown(row, players);

        List<Integer> expected = List.of(1, 0, 3, 2);
        assertThat(actual).containsExactlyElementsOf(expected);
    }

    @Test
    @DisplayName("다리가 없는 경우에 이동이 없는가")
    void no_movement_when_any_bridge_exist() {
        Row row = new Row(3, (ignore) -> EMPTY);
        List<Integer> players = List.of(1, 2, 3, 4);

        List<Integer> actual = LadderClimber.climbDown(row, players);

        assertThat(actual).containsExactlyElementsOf(players);
    }

}
