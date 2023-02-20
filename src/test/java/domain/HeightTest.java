package domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("사다리의 높이는 ")
class HeightTest {

    @DisplayName("1 이상입니다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 10, 11})
    public void heightRangeTest_1(int height) {
        Assertions.assertDoesNotThrow(() -> new Height(height));
    }

    @DisplayName("1 미만일 때 예외가 발생합니다.")
    @ParameterizedTest
    @ValueSource(ints = {0, -1, -2, -10, -11})
    public void heightRangeTest_0(int height) {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Height(height));
    }

}