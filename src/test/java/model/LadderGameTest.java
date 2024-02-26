package model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LadderGameTest {

    @DisplayName("사다리 높이와, 참여자 수, 생성기를 이용하여 사다리를 반환한다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 10, 100})
    void createLadder(int givenHeight) {
        LadderHeight ladderHeight = new LadderHeight(givenHeight);
        Participants participants = new Participants(List.of(
                new Participant("daon"),
                new Participant("ash"),
                new Participant("ted")
        ));
        RandomGenerator randomGenerator = new RandomGenerator();

        LadderGame ladderGame = new LadderGame(ladderHeight, participants, randomGenerator);
        Ladder result = ladderGame.createLadder();

        assertThat(result.getLines()).hasSize(givenHeight);
    }
}
