package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LadderBoardTest {

    private LadderBoard board;
    private List<LadderMachingPair> pairs;
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

        pairs = Arrays.asList(
                LadderMachingPair.of(players.getPlayer(0), rewards.getReward(2)),
                LadderMachingPair.of(players.getPlayer(1), rewards.getReward(0)),
                LadderMachingPair.of(players.getPlayer(2), rewards.getReward(1))
        );
    }

    @Test
    void toString_() throws DuplicatedNameException {
        assertThat(board.toString()).isEqualTo(
                          "     a     b     c\n"
                        + "     |-----|     |\n"
                        + "     |     |-----|\n"
                        + "     1     2     3\n");
    }

    @Test
    void play_한명시도() {
        int idx = 0;
        Player player = players.getPlayer(idx);

        assertThat(board.play(player)).isEqualTo(Arrays.asList(pairs.get(idx)));
    }

    @Test
    void play_ALL() {
        assertThat(board.play(Player.ALL)).isEqualTo(pairs);
    }
}