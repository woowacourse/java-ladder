package laddergame.domain;

import laddergame.utils.RandomLineMaker;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("사다리는 ")
class LadderTest {

    @DisplayName("입력한 높이에 맞게 생성된다")
    @Test
    void test() {
        Height height = new Height(5);
        int userCount = 4;
        Ladder ladder = new Ladder(height, userCount, new RandomLineMaker());

        Assertions.assertThat(ladder.getLines().size()).isEqualTo(height.getHeight());
    }
}
