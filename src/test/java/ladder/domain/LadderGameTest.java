package ladder.domain;

import ladder.domain.participant.ParticipantGroup;
import ladder.domain.reward.RewardGroup;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderGameTest {
    ParticipantGroup participants;
    RewardGroup rewards;
    LadderGame ladderGame;

    @BeforeEach
    public void setup() {
        participants = new ParticipantGroup(Arrays.asList("a", "b", "c"));
        rewards = new RewardGroup(Arrays.asList("1", "2", "3"), 3);
        ladderGame = new LadderGame(participants, rewards, 3);
    }

    @Test
    void getGameResultTest() {
        assertThat(ladderGame.getGameResult().getResult(Arrays.asList("a", "b", "c")).size()).isEqualTo(3);
    }
}
