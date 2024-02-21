package service;

import domain.Ladder;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderGameTest {
    private static final int PERSON_COUNT = 3;
    private static final int HEIGHT = 5;

    @DisplayName("사다리의 높이만큼 Line을 만들어서 사다리를 완성한다")
    @Test
    void createLadder() {
        //given
        final int personCount = PERSON_COUNT;
        final int height = HEIGHT;
        final LadderGame ladderGame = new LadderGame();
        //when
        Ladder ladder = ladderGame.createLadder(personCount, height);
        //then
        Assertions.assertThat(ladder.getLines().size()).isEqualTo(height);
    }
}