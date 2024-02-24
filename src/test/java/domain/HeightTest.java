package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class HeightTest {

    @DisplayName("높이가 1 이상 50 이하가 아니면 예외를 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 51})
    void heightRangeTest(int input) {
        Assertions.assertThatThrownBy(() -> new Height(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("사다리의 높이는 1 이상 50 이하여야 합니다.");
    }
}
