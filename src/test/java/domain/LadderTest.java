package domain;

import domain.Ladder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class LadderTest {

    @Test
    @DisplayName("사다리의 높이는 주어진 높이와 같다")
    void generate() {
        int maxHeight = 4;
        int personCount = 4;

        Ladder ladder = new Ladder(maxHeight, personCount);

        assertThat(maxHeight).isEqualTo(ladder.getHeight());
    }

    @Test
    @DisplayName("사다리 최대 높이는 100이다.")
    void maxHeight() {
        int maxHeight = 101;
        int personCount = 4;

        assertThatThrownBy(() -> new Ladder(maxHeight, personCount))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
