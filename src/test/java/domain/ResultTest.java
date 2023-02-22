package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultTest {

    @Test
    @DisplayName("결과를 생성한다.")
    void createResultSuccess() {
        PlayerName playerName = new PlayerName("pobi");
        Reward reward = new Reward("10000");

        Result result = new Result(playerName, reward);

        assertThat(result.getPlayerName().getPlayerName()).isEqualTo("pobi");
        assertThat(result.getReward().getName()).isEqualTo("10000");
    }

}
