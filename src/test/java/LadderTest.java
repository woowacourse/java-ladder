import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderTest {
    @Test
    @DisplayName("사다리는 높이를 입력받는다.")
    void ladderTest() {
        int height = 4;
        Assertions.assertDoesNotThrow(() -> new Ladder(height));
    }

    @Test
    @DisplayName("사다리의 높이로 음수가 들어오는 경우 예외를 발생시킨다.")
    void ladderHeightNonPositive() {
        int height = -1;
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Ladder(height));
    }
}
