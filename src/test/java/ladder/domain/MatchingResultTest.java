package ladder.domain;

import ladder.domain.participant.Participant;
import ladder.domain.participant.ParticipantGroup;
import ladder.domain.reward.Reward;
import ladder.domain.reward.RewardGroup;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedHashMap;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MatchingResultTest {
    @Test
    void 맵핑하기() {
        MatchingResult matchingResult = new MatchingResult(Arrays.asList(1, 2, 0));
        ParticipantGroup participants = new ParticipantGroup(Arrays.asList("a", "b", "c"));
        RewardGroup rewards = new RewardGroup(Arrays.asList("d", "e", "f"), 3);

        LadderGameResult ladderGameResult = new LadderGameResult(
                new LinkedHashMap<Participant, Reward>() {{
                    put(participants.getNthParticipant(0), rewards.getNthReward(1));
                    put(participants.getNthParticipant(1), rewards.getNthReward(2));
                    put(participants.getNthParticipant(2), rewards.getNthReward(0));
                }}
        );

        assertThat(matchingResult.map(participants, rewards)).isEqualTo(ladderGameResult);
    }

    @Test
    void 맵핑하기에러상황1() {
        MatchingResult matchingResult = new MatchingResult(Arrays.asList(1, 2, 0));
        ParticipantGroup participants = new ParticipantGroup(Arrays.asList("a", "b"));
        RewardGroup rewards = new RewardGroup(Arrays.asList("d", "e", "f"), 3);

        assertThrows(IllegalArgumentException.class, () -> {
            matchingResult.map(participants, rewards);
        });
    }

    @Test
    void 맵핑하기에러상황2() {
        MatchingResult matchingResult = new MatchingResult(Arrays.asList(1, 2, 0));
        RewardGroup rewards = new RewardGroup(Arrays.asList("d", "e", "f"), 3);

        assertThrows(IllegalArgumentException.class, () -> {
            matchingResult.map(null, rewards);
        });
    }
}