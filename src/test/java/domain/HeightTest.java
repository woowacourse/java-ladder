package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class HeightTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 11})
    @DisplayName("사다리 높이가 1~10을 벗어나면 예외가 발생한다.")
    void LadderHeightFailTest(int height) {
        Assertions.assertThatThrownBy(() -> new Height(height))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 10})
    @DisplayName("사다리 높이가 1~10 사이면 정상적으로 수행된다.")
    void LadderHeightSuccessTest(int height) {
        Assertions.assertThatCode(() -> new Height(height)).doesNotThrowAnyException();
    }
}
