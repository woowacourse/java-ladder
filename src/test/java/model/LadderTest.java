package model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LadderTest {
    @Test
    @DisplayName("사다리 높이가 사다리 객체의 크기가 된다.")
    void createLadder() {
        // given
        int height = 5;
        int personCount = 7;

        // when
        Ladder ladder = new Ladder(height, personCount);

        // when
        Assertions.assertThat(ladder.size()).isEqualTo(height);
    }
}
