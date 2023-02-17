package domain;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LinesTest {
    @DisplayName("사다리 높이는 1 이상 100 이하이다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 99, 100})
    void validFloorCountTest(int floorCount) {
        assertDoesNotThrow(() -> new Lines(4, floorCount));
    }

    @DisplayName("사다리 높이가 1 미만 100 초과인 경우 예외 처리한다.")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 101, 102})
    void invalidFloorCountTest(int floorCount) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Lines(4, floorCount));
    }
}
