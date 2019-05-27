package ladder.domain;

import ladder.domain.Reward.Reward;
import ladder.domain.Reward.RewardGroup;
import ladder.domain.participant.Participant;
import ladder.domain.participant.ParticipantGroup;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

class LadderGameResultTest {
    LadderGameResult ladderGameResult;

    @BeforeEach
    public void setup() {
        ParticipantGroup participants = new ParticipantGroup(Arrays.asList("a", "b", "c"));
        RewardGroup rewards = new RewardGroup(Arrays.asList("1", "2", "3"), 3);
        Map<Participant, Reward>gameResult = new HashMap<>();
        for (int i = 0; i<participants.getSize(); i++){
            gameResult.put(participants.getNthParticipant(i),rewards.getNthReward(i));
        }
        ladderGameResult = new LadderGameResult(gameResult);
    }

    @Test
    public void 게임_결과_하나_얻기() {
        LinkedHashMap<String, String> multiResult = new LinkedHashMap<>();
        multiResult.put("a", "1");
        assertThat(ladderGameResult.getResult(Arrays.asList("a"))).isEqualTo(multiResult);
    }

    @Test
    public void 게임_결과_여러개_얻기() {
        LinkedHashMap<String, String> multiResult = new LinkedHashMap<>();
        multiResult.put("a", "1");
        multiResult.put("b", "2");
        assertThat(ladderGameResult.getResult(Arrays.asList("a", "b"))).isEqualTo(multiResult);
    }

    @Test
    public void All_키워드로_얻기() {
        LinkedHashMap<String, String> multiResult = new LinkedHashMap<>();
        multiResult.put("a", "1");
        multiResult.put("b", "2");
        multiResult.put("c", "3");
        assertThat(ladderGameResult.getResult(Arrays.asList("All"))).isEqualTo(multiResult);
    }

    @Test
    public void All_키워드_소문자화_확인(){
        LinkedHashMap<String, String> multiResult = new LinkedHashMap<>();
        multiResult.put("a", "1");
        multiResult.put("b", "2");
        multiResult.put("c", "3");
        assertThat(ladderGameResult.getResult(Arrays.asList("aLl"))).isEqualTo(multiResult);
    }

    @Test
    public void All_입력시_종료() {
        assertThat(ladderGameResult.isEnd()).isFalse();
        ladderGameResult.getResult(Arrays.asList("All"));
        assertThat(ladderGameResult.isEnd()).isTrue();
    }
}