package domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import domain.Height;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class HeightTest {
    @Nested
    @DisplayName("높이 형식 검증 테스트")
    class HeightFormatTest {
        @DisplayName("사다리 높이 입력에 숫자 이외의 문자가 포함되면 실패한다.")
        @ParameterizedTest
        @ValueSource(strings = {"1#", "12a", "일23", "1 2", " "})
        void shouldFailHeightWithNotNumber(String heightInput) {
            assertThatThrownBy(() -> new Height(heightInput)).isInstanceOf(
                            IllegalArgumentException.class)
                    .hasMessageContaining(Height.HEIGHT_FORMAT_ERROR_MESSAGE);
        }

        @DisplayName("사다리 높이 입력에 아무 값을 입력하지 않으면 실패한다.")
        @Test
        void shouldFailHeightWithNothing() {
            assertThatThrownBy(() -> new Height("")).isInstanceOf(
                            IllegalArgumentException.class)
                    .hasMessageContaining(Height.INPUT_NOTHING_ERROR_MESSAGE);
        }
    }

    @Nested
    @DisplayName("높이 제한 조건 검증 테스트")
    class HeightLimitTest {
        @DisplayName("사다리 높이가 음수면 실패한다.")
        @ParameterizedTest
        @ValueSource(strings = {"-1", "-5", "-100"})
        void shouldFailHeightWithNegativeNumber(String heightInput) {
            assertThatThrownBy(() -> new Height(heightInput)).isInstanceOf(
                            IllegalArgumentException.class)
                    .hasMessageContaining(Height.HEIGHT_FORMAT_ERROR_MESSAGE);
        }

        @DisplayName("사다리 높이가 " + Height.MIN_HEIGHT + "이상이면 성공한다.")
        @ParameterizedTest
        @ValueSource(strings = {"0", "3", "10"})
        void shouldSuccessHeightCorrectBoundary(String heightInput) {
            assertDoesNotThrow(() -> new Height(heightInput));
        }
    }
}
