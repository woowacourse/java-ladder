package ladder.domain.laddergame;

import ladder.domain.ladder.Direction;
import ladder.domain.ladder.Height;
import ladder.domain.ladder.Ladder;
import ladder.domain.linegenerator.impl.CustomLineGenerator;
import ladder.domain.linegenerator.impl.RandomLineGenerator;
import ladder.domain.player.Players;
import ladder.domain.reward.Reward;
import ladder.domain.reward.Rewards;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LadderGameTest {

    private Players players;
    private Rewards rewards;
    private Ladder ladder;
    private LadderGame ladderGame;

    @BeforeEach
    void setUp() {
        players = new Players(new String[]{"pobi", "denis", "whale"});
        rewards = new Rewards(new String[]{"100", "200", "300"});
        List<Direction> directions = Arrays.asList(Direction.RIGHT, Direction.LEFT, Direction.STRAIGHT);
        ladder = new Ladder(new CustomLineGenerator(directions), new Height(3));
    }

    @Test
    void player수와_reward수가_다른_경우() {
        players = new Players(new String[]{"pobi", "denis"});
        ladder = new Ladder(new RandomLineGenerator(players.size()), new Height(5));
        ladderGame = new LadderGame(ladder);

        assertThatThrownBy(() -> ladderGame.play(players, rewards)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void ladderGame진행() {
        LadderGame ladderGame = new LadderGame(ladder);
        ladderGame.play(players, rewards);

    }
}
