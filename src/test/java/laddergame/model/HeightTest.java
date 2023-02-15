package laddergame.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("사다리 높이에 ")
class HeightTest {
    @Test
    @DisplayName("1이상인 값이 들어오면 오류가 발생하지 않는다.")
    void Should_Success_When_HeightInput() {
        assertDoesNotThrow(() -> new Height(1));
    }

    @ParameterizedTest(name = "{displayName} {index} ==> height : ''{0}''")
    @ValueSource(ints = {0, -1})
    @DisplayName("1보다 작은 값이 들어오는 경우 예외 발생")
    void Should_ThrowException_When_LessThanOne(int height) {
        assertThatThrownBy(() -> new Height(height));
    }
}
