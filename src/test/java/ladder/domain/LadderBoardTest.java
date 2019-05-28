package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class LadderBoardTest {

    private LadderBoard board;
    private Players players;
    private Rewards rewards;

    @BeforeEach
    void setUp() throws DuplicatedNameException {
        Ladder ladder = Ladder.from(Arrays.asList(
                HorizontalLine.from(Arrays.asList(Direction.RIGHT, Direction.LEFT, Direction.NONE)),
                HorizontalLine.from(Arrays.asList(Direction.NONE, Direction.RIGHT, Direction.LEFT))
        ));
        players = Players.from(Arrays.asList("a", "b", "c"));
        rewards = Rewards.from(Arrays.asList("1", "2", "3"));

        board = LadderBoard.of(ladder, players, rewards);


    }

    @Test
    void toString_() {
        assertThat(board.toString()).isEqualTo(
                          "     a     b     c\n"
                        + "     |-----|     |\n"
                        + "     |     |-----|\n"
                        + "     1     2     3\n");
    }

    @Test
    void play_() {
        GameResult gameResult = GameResult.of(players.toList(), Rewards.from(Arrays.asList("3", "1", "2")).toList());
        assertThat(board.play()).isEqualTo(gameResult);
    }
}