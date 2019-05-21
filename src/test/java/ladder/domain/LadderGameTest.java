package ladder.domain;

import ladder.domain.Reward.RewardGroup;
import ladder.domain.participant.ParticipantGroup;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderGameTest {
    ParticipantGroup participants;
    RewardGroup rewardGroup;
    LadderGame ladderGame;

    @BeforeEach
    public void setup() {
        participants = new ParticipantGroup(Arrays.asList("a", "b", "c"));
        rewardGroup = new RewardGroup(Arrays.asList("1", "2", "3"), 3);
        ladderGame = new LadderGame(participants, 3);
    }

    @Test
    void 게임_결과_받아오기() {
        assertThat(ladderGame.matchingPoint().getMatchingResult().size()).isEqualTo(new ArrayList<>(Arrays.asList(1,2,3)).size());
    }
}
