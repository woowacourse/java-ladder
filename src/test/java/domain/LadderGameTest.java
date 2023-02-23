package domain;

import domain.util.PointGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderGameTest {
    @Test
    @DisplayName("사다리 게임을 실행하면 사다리를 읽으며 순서를 변화시킨다.")
    void runLadderGameTest() {
        Participants participants = new Participants();
        participants.add(new Participant("echo"));
        participants.add(new Participant("modi"));
        participants.add(new Participant("neo"));

        LadderGame ladderGame = new LadderGame(participants, new LadderHeight(1), PointGenerator.getInstance(false));
        SequenceSwapper swapper = SequenceSwapper.of(List.of(0, 1, 2));
        ladderGame.run(swapper);
        assertThat(swapper.getSequence()).containsExactly(1, 0, 2);
    }
}
