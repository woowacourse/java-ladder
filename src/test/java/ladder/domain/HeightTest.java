package ladder.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class HeightTest {

    @ParameterizedTest(name = "높이는 자연수여야 한다.")
    @ValueSource(ints = {-1, 0, 10001})
    void validateHeightFailTest(int height) {
        assertThatThrownBy(() -> new Height(height))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest(name = "높이는 1부터 10000까지의 자연수여야 한다.")
    @ValueSource(ints = {1, 10000})
    void validateHeightSuccessTest(int height) {
        Assertions.assertDoesNotThrow(() -> new Height(height));
    }
}
