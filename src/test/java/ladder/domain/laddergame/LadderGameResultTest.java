package ladder.domain.laddergame;

import ladder.domain.ladder.Direction;
import ladder.domain.ladder.Height;
import ladder.domain.ladder.Ladder;
import ladder.domain.linegenerator.impl.CustomLineGenerator;
import ladder.domain.player.Player;
import ladder.domain.player.Players;
import ladder.domain.reward.Reward;
import ladder.domain.reward.Rewards;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderGameResultTest {
    private Players players;
    private Rewards rewards;
    private Ladder ladder;
    private LadderGame ladderGame;
    private LadderGameResult ladderGameResult;

    @BeforeEach
    void setUp() {
        players = new Players(new String[]{"pobi", "denis", "whale"});
        rewards = new Rewards(new String[]{"100", "200", "300"});
        List<Direction> directions = Arrays.asList(Direction.RIGHT, Direction.LEFT, Direction.STRAIGHT);
        ladder = new Ladder(new CustomLineGenerator(directions), new Height(3));
        ladderGame = new LadderGame(ladder);
        ladderGameResult = ladderGame.play(players, rewards);
    }

    @Test
    void 이름에_맞는_상품_찾기() {
        assertThat(ladderGameResult.findReward("pobi")).isEqualTo(new Reward("200"));
        assertThat(ladderGameResult.findReward("denis")).isEqualTo(new Reward("100"));
        assertThat(ladderGameResult.findReward("whale")).isEqualTo(new Reward("300"));
    }
}
