import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import validate.InputVerifier;

public class HeightTest {
    InputVerifier inputVerifier = new InputVerifier();

    @Nested
    @DisplayName("높이 형식 검증 테스트")
    class HeightFormatTest {
        @DisplayName("사다리 높이 입력에 숫자 이외의 문자가 포함되면 실패한다.")
        @ParameterizedTest
        @ValueSource(strings = {"1#", "12a", "일23", "1 2", " "})
        void shouldFailHeightWithNotNumber(String heightInput) {
            assertThatThrownBy(() -> inputVerifier.validateHeightInput(heightInput)).isInstanceOf(
                            IllegalArgumentException.class)
                    .hasMessageContaining(InputVerifier.HEIGHT_FORMAT_ERROR_MESSAGE);
        }

        @DisplayName("사다리 높이 입력에 아무 값을 입력하지 않으면 실패한다.")
        @Test
        void shouldFailHeightWithNothing() {
            assertThatThrownBy(() -> inputVerifier.validateHeightInput("")).isInstanceOf(
                            IllegalArgumentException.class)
                    .hasMessageContaining(InputVerifier.INPUT_NOTHING_ERROR_MESSAGE);
        }
    }
}
