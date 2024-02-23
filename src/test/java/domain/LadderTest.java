package domain;

import domain.Ladder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class LadderTest {

    @Test
    @DisplayName("사람 수와 높이로 Ladder 생성")
    void createLadderWithPersonCountAndMaxHeight() {
        int maxHeight = 4;
        int personCount = 4;

        assertThatCode(() -> new Ladder(maxHeight, personCount)).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("사다리를 생성한다")
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
