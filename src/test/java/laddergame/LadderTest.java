package laddergame;

import static org.assertj.core.api.Assertions.assertThat;

import laddergame.domain.Ladder;
import laddergame.domain.LadderHeight;
import laddergame.domain.RandomBooleanGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LadderTest {

    @DisplayName("사다리를 생성한다.")
    @Test
    void createLadder() {
        // given
        final LadderHeight height = new LadderHeight(5);
        int personSize = 4;

        // when
        Ladder ladder = Ladder.create(height, new RandomBooleanGenerator(personSize-1));

        // then
        assertThat(ladder.getHeight()).isEqualTo(height.getHeight());
    }
}
