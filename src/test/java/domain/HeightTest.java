package domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("높이")
public class HeightTest {

    public static final String RANGE_ERROR_MESSAGE = "사다리 높이는 1 ~ 100만 가능합니다.";

    @DisplayName("범위 밖인 경우 예외 발생")
    @ParameterizedTest
    @ValueSource(ints = {0, 101})
    void createHeightFail(int input) {
        assertThatThrownBy(() -> new Height(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(RANGE_ERROR_MESSAGE);
    }

    @DisplayName("범위 내인 경우 정상 작동")
    @ParameterizedTest
    @ValueSource(ints = {1, 100})
    void createHeightSuccess(int input) {
        Assertions.assertDoesNotThrow(() -> new Height(input));
    }
}
