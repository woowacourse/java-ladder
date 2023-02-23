package domain;

import domain.util.PointGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderGameTest {
    private LadderGame ladderGame;
    @BeforeEach
    void generateLadderGame(){
        Participants participants = Participants.of("echo", "modi", "neo");
        Results results = Results.of("3000", "꽝", "5000");
        Ladder ladder = Ladder.create(new LadderHeight(1), new LadderWidth(2), PointGenerator.getInstance(false));
        ladderGame = new LadderGame(participants, results, ladder);
    }
    @Test
    @DisplayName("사다리 게임을 실행하면 사다리를 읽으며 순서를 변화시킨다.")
    void runLadderGameTest() {
        SequenceSwapper swapper = SequenceSwapper.of(List.of(0, 1, 2));
        ladderGame.run(swapper);
        assertThat(swapper.getSequence()).containsExactly(1, 0, 2);
    }

    @Test
    @DisplayName("사다리 게임을 실행하면 참가자들과 결과 맵을 생성한다.")
    void getLadderGameResultMap(){
        SequenceSwapper swapper = SequenceSwapper.of(List.of(0,1,2));

        ladderGame.run(swapper);
        assertThat(ladderGame.getGameResult().get(Participant.from("echo"))).isEqualTo(Result.from("5000"));
    }
}
