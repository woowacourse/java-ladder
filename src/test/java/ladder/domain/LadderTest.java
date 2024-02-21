package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import static ladder.domain.Direction.NONE;
import static ladder.domain.Direction.RIGHT;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LadderTest {
    @DisplayName("인원수, 높이가 자연수가 아닌 경우 예외가 발생한다.")
    @Test
    void ladderHeightTest() {
        assertThatThrownBy(() -> new Ladder(-1, 1))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Ladder(1, -1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력받은 위치의 방향을 찾는다.")
    @Test
    void ladderTest() {
        int peopleCount = 5;
        int height = 4;
        Ladder ladder = new Ladder(peopleCount, height);
        ladder.initialize(() -> RIGHT);

        assertThat(ladder.getDirection(0, 0)).isEqualTo(RIGHT);
        
        ladder.initialize(() -> NONE);

        assertThat(ladder.getDirection(0, 0)).isEqualTo(NONE);
    }

}
