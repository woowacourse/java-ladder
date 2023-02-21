package ladder.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import ladder.error.ErrorMessage;

class LadderHeightTest {

    @ParameterizedTest(name = "높이는 자연수여야 한다.")
    @ValueSource(ints = {-1, 0, 10001})
    void validateHeightFailTest(int height) {
        assertThatThrownBy(() -> new LadderHeight(height))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(ErrorMessage.INVALID_HEIGHT_RANGE.getMessage());
    }

    @ParameterizedTest(name = "높이는 1부터 10000까지의 자연수여야 한다.")
    @ValueSource(ints = {1, 10000})
    void validateHeightSuccessTest(int height) {
        assertDoesNotThrow(() -> new LadderHeight(height));
    }
}
