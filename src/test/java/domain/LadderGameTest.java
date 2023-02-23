package domain;

import domain.util.PointGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderGameTest {
    private LadderGame ladderGame;
    @BeforeEach
    void generateLadderGame(){
        Participants participants = new Participants();
        participants.add(new Participant("echo"));
        participants.add(new Participant("modi"));
        participants.add(new Participant("neo"));
        List<Result> collectedList = Stream.of("꽝", "5000", "꽝")
                .map(Result::from)
                .collect(Collectors.toList());
        Results results = Results.of(collectedList);
        LadderHeight ladderHeight = new LadderHeight(1);
        PointGenerator generator = PointGenerator.getInstance(false);
        ladderGame = new LadderGame(participants,ladderHeight, results,PointGenerator.getInstance(false));
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
        assertThat(ladderGame.getGameResult().getValue("echo")).isEqualTo("5000");
    }
}
