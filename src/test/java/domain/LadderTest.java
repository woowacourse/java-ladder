package domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderTest {
    @Test
    @DisplayName("사다리는 높이를 입력받는다.")
    void ladderTest() {
        int height = 4;
        int personCount = 5;
        Assertions.assertDoesNotThrow(() -> Ladder.generateByHeightPersonCount(height, personCount));
    }

    @Test
    @DisplayName("사다리의 높이로 음수가 들어오는 경우 예외를 발생시킨다.")
    void ladderHeightNonPositive() {
        int height = -1;
        int personCount = 5;
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> Ladder.generateByHeightPersonCount(height, personCount));
    }
}
