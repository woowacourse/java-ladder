package domain;

import domain.ladder.Height;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("높이 값은 ")
class HeightTest {
    @Nested
    @DisplayName("생성될 때 ")
    class GeneratedCase {
        @ParameterizedTest(name = "{displayName} - {0}")
        @DisplayName("정상적인 높이면 허용한다.")
        @ValueSource(ints = {2, 10})
        void givenValidHeight_thenSuccess(final int height) {
            assertThatCode(() -> Height.of(height))
                    .doesNotThrowAnyException();
        }

        @ParameterizedTest(name = "{displayName} - {0}")
        @DisplayName("비정상적인 높이면 익셉션을 발생한다.")
        @ValueSource(ints = {1, 11})
        void givenInValidHeight_thenThrowException(final int height) {
            assertThatThrownBy(() -> Height.of(height))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("사다리 길이는 2에서 10사이여야 합니다.");
        }
    }
}