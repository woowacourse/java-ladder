package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class HeightTest {

    @Test
    @DisplayName("높이 입력값이 양수일 때 정상적인 객체 생성")
    void makeHeightUsingPositiveNumberAsAnInput() {
        int height = 1;
        assertDoesNotThrow(() -> new Height(height));
    }

    @ParameterizedTest
    @DisplayName("높이 입력값이 0이거나 음수일 경우 예외 발생")
    @ValueSource(ints = {-100, -5, -1, 0})
    void throwExceptionUsingNegativeNumberOrZeroAsAnInput(int height) {
        Assertions.assertThatThrownBy(() -> new Height(height))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 높이는 양수만 가능합니다.");
    }
}
