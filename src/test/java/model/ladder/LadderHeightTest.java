package model.ladder;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LadderHeightTest {

    @DisplayName("사다리 높이가 1미만이면 예외 발생")
    @ParameterizedTest
    @ValueSource(ints = {0, -1})
    void testInvalidValueOfHeight(int height) {
        assertThatThrownBy(() -> new LadderHeight(height))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사다리 높이가 1이상이면 객체 생성 성공")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 10, 100, 1000000})
    void testValidValueOfHeight(int height) {
        assertThatCode(() -> new LadderHeight(height))
            .doesNotThrowAnyException();
    }
}
