package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {

    @Test
    @DisplayName("라인의 수는 입력받은 최대 사다리 높이다.")
    void createLadder() {
        // given
        int height = 5;

        // when
        Ladder ladder = new Ladder(height, 4);

        // then
        assertThat(ladder.getLines().size()).isEqualTo(height);
    }

}