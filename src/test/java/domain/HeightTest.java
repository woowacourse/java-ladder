package domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

public class HeightTest {

    @DisplayName("사다리 높이가 자연수가 아닐 경우 예외가 발생한다.")
    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"abc", "-1", "0"})
    void occurExceptionIfHeightIsNotNaturalNumber(String height) {
        assertThatThrownBy(() -> new Height(height))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Height.ERROR_HEIGHT_IS_NOT_NATURAL_NUMBER);
    }
}
