package ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LadderTest {
    @ParameterizedTest
    @CsvSource(value = {"0,5", "-1,5"})
    @DisplayName("사다리 높이가 자연수가 아니면 예외가 발생한다.")
    void ladderHeightRangeTest(int height, int width) {
        assertThatThrownBy(() -> Ladder.of(height, width))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"5,0", "5,-1"})
    @DisplayName("사다리 너비가 자연수가 아니면 예외가 발생한다.")
    void ladderWidthRangeTest(int height, int width) {
        assertThatThrownBy(() -> Ladder.of(height, width))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2", "3,4", "10,10"})
    @DisplayName("유효한 가로줄을 포함하는 사다리를 생성할 수 있다.")
    void createValidLadderTest(int height, int width) {
        assertThatCode(() -> Ladder.of(height, width))
                .doesNotThrowAnyException();
    }
}
