package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

    @DisplayName("입력받은 인원수와 높이의 사다리를 만든다.")
    @Test
    void ladderTest() {
        int peopleCount = 5;
        int height = 4;
        Ladder ladder = new Ladder(peopleCount, height);

        assertThat(ladder.lines.size()).isEqualTo(height);
        assertThat(ladder.lines.get(0).line.size()).isEqualTo(peopleCount);
    }

}
