package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultsTest {

    @Test
    @DisplayName("결과 목록을 생성한다.")
    void createResultsSuccess() {
        Players players = Players.from(List.of("pobi", "hell"));
        Rewards rewards = Rewards.from(players.getSize(), List.of("fail", "5000"));
        Results results = Results.from(players.getPlayers(), rewards.getRewards());

        List<Result> extractedResult = results.getResults();

        assertThat(extractedResult.get(0).getPlayer().getName()).isEqualTo("pobi");
        assertThat(extractedResult.get(0).getReward().getName()).isEqualTo("fail");
        assertThat(extractedResult.get(1).getPlayer().getName()).isEqualTo("hell");
        assertThat(extractedResult.get(1).getReward().getName()).isEqualTo("5000");
    }

}
