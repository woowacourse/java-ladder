package model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LadderGameTest {
    @DisplayName("사다리 높이와 참여자들, 난수생성기를 입력받아 객체를 생성한다.")
    @Test
    void createLadderGame() {
        int ladderHeight = 2;
        Participants participants = new Participants(List.of(
                new Participant("daon"),
                new Participant("ash"),
                new Participant("ted")
        ));
        RandomGenerator randomGenerator = new RandomGenerator();

        assertThatCode(() -> new LadderGame(ladderHeight, participants, randomGenerator))
                .doesNotThrowAnyException();
    }

    @DisplayName("사다리 높이가 0 이하면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {-5, -1, 0})
    void validateLadderHeight(int given) {
        Participants participants = new Participants(List.of(
                new Participant("daon"),
                new Participant("ash"),
                new Participant("ted")
        ));
        RandomGenerator randomGenerator = new RandomGenerator();

        assertThatThrownBy(() -> new LadderGame(given, participants, randomGenerator))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 사다리 높이는")
                .hasMessageContaining("이상의 정수이어야 한다.");
    }

    @DisplayName("사다리 높이와, 참여자 수, 생성기를 이용하여 사다리를 반환한다.")
    @Test
    void createLadder() {
        int ladderHeight = 3;
        Participants participants = new Participants(List.of(
                new Participant("daon"),
                new Participant("ash"),
                new Participant("ted")
        ));
        RandomGenerator randomGenerator = new RandomGenerator();
        LadderGame ladderGame = new LadderGame(ladderHeight, participants, randomGenerator);
        Ladder result = ladderGame.createLadder();

        assertThat(result.getLines()).hasSize(ladderHeight);
    }
}
