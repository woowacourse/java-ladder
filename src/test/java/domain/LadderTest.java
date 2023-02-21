package domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {

    private final int validatePersonCount = 5;

    @ParameterizedTest(name = "입력된 사다리의 높이 = {0}")
    @DisplayName("입력된 사다리의 높이가 1~100 사이면 해당 높이의 사다리가 생성된다.")
    @ValueSource(ints = {1,50,100})
    void ladderHeightTest(int height) {
        Ladder ladder = new Ladder(height, validatePersonCount);
        int ladderHeight = ladder.getLadder().size();
        assertThat(ladderHeight).isEqualTo(height);
    }

    @Test
    @DisplayName("사다리의 높이로 0이 들어오는 경우 예외를 발생시킨다.")
    void ladderHeightZeroTest() {
        int height = 0;
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Ladder(height, validatePersonCount));
    }

    @Test
    @DisplayName("사다리의 높이로 음수가 들어오는 경우 예외를 발생시킨다.")
    void ladderHeightNegativeTest() {
        int height = -1;
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Ladder(height, validatePersonCount));
    }

    @Test
    @DisplayName("사다리의 높이로 100을 초과하는 수가 들어오는 경우 예외를 발생시킨다.")
    void ladderHeightOver100Test() {
        int height = 101;
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Ladder(height, validatePersonCount));
    }
}
