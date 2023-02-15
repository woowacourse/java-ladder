package domain;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class HeightTest {
    @DisplayName("사다리 높이는 1 이상 100 이하이다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 99, 100})
    void validHeightTest(int height) {
        Assertions.assertDoesNotThrow(() -> new Height(height));
    }

    @DisplayName("1 미만 100 초과의 사다리 높이는 예외 처리한다.")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 101, 102})
    void invalidHeightTest(int height) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Height(height));
    }

}