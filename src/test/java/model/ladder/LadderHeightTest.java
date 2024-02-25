package model.ladder;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LadderHeightTest {
    @DisplayName("사다리 높이가 1미만이면 예외가 발생한다")
    @ParameterizedTest
    @CsvSource({"0", "-1"})
    void testInvalidValueOfHeight(int height) {
        assertThatThrownBy(() -> new LadderHeight(height))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사다리 높이가 1이상이면 예외가 발생하지 않는다")
    @ParameterizedTest
    @CsvSource({"1", "2", "10", "100", "1000000"})
    void testValidValueOfHeight(int height) {
        assertDoesNotThrow(() -> new LadderHeight(height));
    }
}
