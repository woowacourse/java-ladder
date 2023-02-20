package domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {
    private final int validatePersonCount = 5;

    @Test
    @DisplayName("사다리의 높이로 1~100 사이의 수(1)를 입력받는다.")
    void ladderMinHeightTest() {
        int height = 1;
        Assertions.assertDoesNotThrow(() -> new Ladder(height, validatePersonCount));
    }

    @Test
    @DisplayName("사다리의 높이로 1~100 사이의 수(100)를 입력받는다.")
    void ladderMaxHeightTest() {
        int height = 100;
        Assertions.assertDoesNotThrow(() -> new Ladder(height, validatePersonCount));
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

    @ParameterizedTest(name = "입력된 사다리의 높이 = {0}")
    @DisplayName("입력된 사다리의 높이에 맞는 사다리가 생성되었는지 확인한다.")
    @ValueSource(ints = {1,50,100})
    void ladderHeightTest(int height) {
        Ladder ladder = new Ladder(height, validatePersonCount);
        int ladderHeight = ladder.getLadder().size();
        assertThat(ladderHeight).isEqualTo(height);
    }
}
