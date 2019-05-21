package ladder.domain;

import ladder.domain.ladder.ForcedRule;
import ladder.domain.participant.ParticipantGroup;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class LadderGameTest {
    private ParticipantGroup participants;
    private LadderGame ladderGame;

    @BeforeEach
    void setup() {
        participants = new ParticipantGroup(Arrays.asList("a", "b", "c", "d"));
        ladderGame = new LadderGame(participants, 3, new ForcedRule());
    }

    @Test
    void 게임실행() {
        assertThat(ladderGame.play()).isEqualTo(new MatchingResult(Arrays.asList(3, 1, 2, 0)));
    }
}
