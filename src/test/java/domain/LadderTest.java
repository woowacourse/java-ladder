package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
@DisplayName("사다리는 ")
class LadderTest {
    @Nested
    @DisplayName("다리를 만들 때 ")
    class GenerateLineCase {
        @Disabled
        @ParameterizedTest(name = "{displayName}")
        @DisplayName("정상적인 높이면 해당 높이만큼 다리를 생성한다.")
        @ValueSource(ints = {2, 3, 4, 5, 6, 7, 8, 9, 10})
        void givenValidHeight_thenBuildLines(final int height) {
            Ladder ladder = new Ladder();
            ladder.build(height);
            Assertions.assertThat(ladder.getLineHeight()).isEqualTo(height);
        }

        @ParameterizedTest(name = "{displayName} - {0}")
        @DisplayName("비정상적인 높이면 익셉션을 발생한다.")
        @ValueSource(ints = {0, 1, 11, 12})
        void givenInValidHeight_thenThrowException(final int height) {
            Ladder ladder = new Ladder();

            Assertions.assertThatThrownBy(() -> ladder.build(height))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("사다리 길이는 2에서 10사이여야 합니다.");
        }
    }
}