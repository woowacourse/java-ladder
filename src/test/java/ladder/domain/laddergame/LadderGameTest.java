package ladder.domain.laddergame;

import ladder.domain.ladder.Height;
import ladder.domain.ladder.Ladder;
import ladder.domain.laddergame.LadderGame;
import ladder.domain.player.Players;
import ladder.domain.reward.Rewards;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LadderGameTest {
    @Test
    void player수와_reward수가_다른_경우() {
        Players players = new Players(new String[]{"pobi", "denis"});
        Rewards rewards = new Rewards(new String[]{"100", "200", "300"});
        Ladder ladder = new Ladder(players.size(), new Height(5));
        LadderGame ladderGame = new LadderGame(ladder);

        assertThatThrownBy(() -> ladderGame.play(players, rewards)).isInstanceOf(IllegalArgumentException.class);
    }
}
