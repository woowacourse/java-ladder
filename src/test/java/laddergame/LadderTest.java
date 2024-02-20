package laddergame;

import static org.assertj.core.api.Assertions.assertThat;

import laddergame.domain.Ladder;
import laddergame.domain.RandomBooleanGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LadderTest {

    @DisplayName("사다리를 생성한다.")
    @Test
    void createLadder() {
        // given
        int height = 5;
        int personSize = 4;

        // when
        Ladder ladder = Ladder.create(height, personSize, new RandomBooleanGenerator());

        // then
        assertThat(ladder.getHeight()).isEqualTo(height);
    }
}
