package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LineTest {

    @DisplayName("입력받은 숫자가 1 이상 50 이하가 아닌 경우 예외를 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 51})
    void heightRangeTest(int input) {
        Assertions.assertThatThrownBy(() -> new Line(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자는 1 이상 50 이하여야 합니다.");
    }
}
