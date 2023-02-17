package domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderTest {
    private final int validatePersonCount = 5;

    @Test
    @DisplayName("사다리의 높이로 1~100 사이의 수를 입력받는다.")
    void ladderTest() {
        int height = 1;
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
}
