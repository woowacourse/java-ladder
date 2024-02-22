package model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LadderGameTest {

    @DisplayName("사다리 높이와 참여자들, 난수생성기를 입력받아 객체를 생성한다.")
    @Test
    void createLadderGame() {
        LadderHeight ladderHeight = new LadderHeight(2);
        Participants participants = new Participants(List.of(
                new Participant("daon"),
                new Participant("ash"),
                new Participant("ted")
        ));
        RandomGenerator randomGenerator = new RandomGenerator();

        assertThatCode(() -> new LadderGame(ladderHeight, participants, randomGenerator))
                .doesNotThrowAnyException();
    }

    @DisplayName("사다리 높이와, 참여자 수, 생성기를 이용하여 사다리를 반환한다.")
    @Test
    void createLadder() {
        LadderHeight ladderHeight = new LadderHeight(3);
        Participants participants = new Participants(List.of(
                new Participant("daon"),
                new Participant("ash"),
                new Participant("ted")
        ));
        RandomGenerator randomGenerator = new RandomGenerator();
        LadderGame ladderGame = new LadderGame(ladderHeight, participants, randomGenerator);
        Ladder result = ladderGame.createLadder();

        assertThat(result).isNotNull();
    }
}
