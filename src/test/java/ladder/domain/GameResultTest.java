package ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class GameResultTest {

    @Test
    void of_플레이어와_보상의_수가_다를때() {
        List<Player> players = Arrays.asList(Player.from("1"));
        List<Reward> resultRewards = Arrays.asList(Reward.from("짠!"), Reward.from("짜잔!"));

        assertThrows(IllegalArgumentException.class, () -> GameResult.of(players, resultRewards));
    }

    @Test
    void getResultReward_() {
        List<Player> players = Arrays.asList(Player.from("밥"), Player.from("살빼기!"));
        List<Reward> resultRewards = Arrays.asList(Reward.from("맛있다!"), Reward.from("망했다.."));
        GameResult gameResult = GameResult.of(players, resultRewards);

        for (int i = 0; i < players.size(); i++) {
            Player player = players.get(i);
            Reward expectedResultReward = resultRewards.get(i);

            assertThat(gameResult.getResultReward(player)).isEqualTo(expectedResultReward);
        }
    }
}