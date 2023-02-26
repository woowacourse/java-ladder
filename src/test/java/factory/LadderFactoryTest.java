package factory;

import domain.Ladder;
import domain.RandomBasedStrategy;
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
        RandomBasedStrategy randomBasedStrategy = new RandomBasedStrategy();

        // when
        Ladder ladder = LadderFactory.of(playerSize, ladderHeight, randomBasedStrategy);

        // then
        assertThat(ladder.getLines().size())
                .isEqualTo(ladderHeight);
    }

}