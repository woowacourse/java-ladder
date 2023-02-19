package domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("사다리의 높이는 ")
class HeightTest {

    @DisplayName("1 이상입니다.")
    @Test
    public void heightRangeTest_1() {
        Assertions.assertDoesNotThrow(() -> new Height(1));
    }

    @DisplayName("1 미만일 때 예외가 발생합니다.")
    @Test
    public void heightRangeTest_0() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Height(0));
    }

}