package ladder.domain;

import ladder.domain.participant.Participant;
import ladder.domain.participant.ParticipantGroup;
import ladder.domain.reward.Reward;
import ladder.domain.reward.RewardGroup;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedHashMap;

import static org.assertj.core.api.Assertions.assertThat;

class LadderGameResultTest {
    private LadderGameResult ladderGameResult;

    @BeforeEach
    void setup() {
        ParticipantGroup participants = new ParticipantGroup(Arrays.asList("a", "b", "c"));
        RewardGroup rewards = new RewardGroup(Arrays.asList("1", "2", "3"), 3);
        ladderGameResult = new LadderGameResult(
                new LinkedHashMap<Participant, Reward>() {{
                    put(participants.getNthParticipant(0), rewards.getNthReward(1));
                    put(participants.getNthParticipant(1), rewards.getNthReward(2));
                    put(participants.getNthParticipant(2), rewards.getNthReward(0));
                }}
        );
    }

    @Test
    void 게임결과하나얻기() {
        LinkedHashMap<String, String> multiResult = new LinkedHashMap<>();
        multiResult.put("a", "2");
        assertThat(ladderGameResult.getResult(Arrays.asList("a"))).isEqualTo(multiResult);
    }

    @Test
    void 게임결과여러개얻기() {
        LinkedHashMap<String, String> multiResult = new LinkedHashMap<>();
        multiResult.put("a", "2");
        multiResult.put("b", "3");
        assertThat(ladderGameResult.getResult(Arrays.asList("a", "b"))).isEqualTo(multiResult);
    }

    @Test
    void All키워드로얻기() {
        LinkedHashMap<String, String> multiResult = new LinkedHashMap<>();
        multiResult.put("a", "2");
        multiResult.put("b", "3");
        multiResult.put("c", "1");
        assertThat(ladderGameResult.getResult(Arrays.asList("all"))).isEqualTo(multiResult);
        assertThat(ladderGameResult.getResult(Arrays.asList("All"))).isEqualTo(multiResult);
        assertThat(ladderGameResult.getResult(Arrays.asList("aLl"))).isEqualTo(multiResult);
    }

    @Test
    void All입력시종료() {
        assertThat(ladderGameResult.isEnd()).isFalse();
        ladderGameResult.getResult(Arrays.asList("All"));
        assertThat(ladderGameResult.isEnd()).isTrue();
    }
}