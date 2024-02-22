package service;

import domain.Ladder;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderMakerTest {

    @DisplayName("사다리의 높이만큼 Line을 만들어서 사다리를 완성한다")
    @Test
    void createLadder() {
        //given
        final int personCount = 4;
        final int height = 5;
        final LadderMaker ladderMaker = new LadderMaker();
        //when
        Ladder ladder = ladderMaker.createLadder(personCount, height);
        //then
        Assertions.assertThat(ladder.getLines().size()).isEqualTo(height);
    }
}