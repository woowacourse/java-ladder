package ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class LadderBoardTest {

    @Test
    void toString_() throws DuplicatedNameException {
        Ladder ladder = Ladder.from(Arrays.asList(
                HorizontalLine.from(Arrays.asList(Direction.RIGHT, Direction.LEFT, Direction.NONE)),
                HorizontalLine.from(Arrays.asList(Direction.NONE, Direction.RIGHT, Direction.LEFT))
        ));
        Players players = Players.from(Arrays.asList("a", "b", "c"));
        Rewards rewards = Rewards.from(Arrays.asList("1", "2", "3"));


        assertThat(LadderBoard.of(ladder, players, rewards).toString()).isEqualTo(
                          "     a     b     c\n"
                        + "     |-----|     |\n"
                        + "     |     |-----|\n"
                        + "     1     2     3\n");
    }
}