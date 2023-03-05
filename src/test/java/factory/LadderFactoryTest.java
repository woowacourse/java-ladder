package factory;

import domain.Ladder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.assertThat;

class LadderFactoryTest {

    @DisplayName("Ladder를 생성한다.")
    @Test
    void generateLadder() {
        // given
        int playerSize = 5;
        int ladderHeight = 3;

        // when
        Ladder ladder = LadderFactory.of(playerSize, ladderHeight);

        // then
        assertThat(ladder.getLines().size())
                .isEqualTo(ladderHeight);
    }

}