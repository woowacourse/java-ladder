package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultTest {

    @Test
    @DisplayName("결과를 생성한다.")
    void createResultSuccess() {
        Player player = new Player("pobi", 0);
        Reward reward = new Reward("10000");

        Result result = new Result(player, reward);

        assertThat(result.getPlayerName()).isEqualTo("pobi");
        assertThat(result.getRewardName()).isEqualTo("10000");
    }

}
