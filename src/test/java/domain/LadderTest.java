package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import util.FixBooleanGenerator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("사다리는 ")
class LadderTest {
    @Nested
    @DisplayName("다리를 만들 때 ")
    class GenerateLineCase {
        @Nested
        @DisplayName("높이 검증을 한다. ")
        class ValidatingHeightCase {
            @ParameterizedTest(name = "{displayName}")
            @DisplayName("정상적인 높이면 해당 높이만큼 다리를 생성한다.")
            @ValueSource(ints = {2, 3, 4, 5, 6, 7, 8, 9, 10})
            void givenValidHeight_thenBuildLines(final int height) {
                Ladder ladder = new Ladder();
                ladder.build(height);
                assertThat(ladder.getLineHeight()).isEqualTo(height);
            }

            @ParameterizedTest(name = "{displayName} - {0}")
            @DisplayName("비정상적인 높이면 익셉션을 발생한다.")
            @ValueSource(ints = {0, 1, 11, 12})
            void givenInValidHeight_thenThrowException(final int height) {
                Ladder ladder = new Ladder();

                assertThatThrownBy(() -> ladder.build(height))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("사다리 길이는 2에서 10사이여야 합니다.");
            }
        }

        @Nested
        @DisplayName(" 원하는 모양대로 만들 수 있다.")
        class ShapeCase {
            private Ladder ladder;

            @BeforeEach
            void setUp() {
                ladder = new Ladder(new FixBooleanGenerator(true, false, false, false, true, false));
            }

            @Test
            @DisplayName(" 주어진 사람 수만큼 다리의 폭이 생성된다.")
            void givenThree_thenGenerateThreeWidth() {
                ladder.build(2, 3);
                assertThat(ladder.getWidth()).isEqualTo(3);
            }

            @Test
            @DisplayName(" 주어진 다리 높이만큼 다리가 생성된다.")
            void givenThreeHeight_thenGenerateThreeHeight() {
                ladder.build(3, 2);
                assertThat(ladder.getLineHeight()).isEqualTo(3);
            }

            @Test
            @DisplayName(" 주어진 정보에 맞는 개수의 디딤돌이 생성된다.")
            void givenInformation_thenGenerateLadder() {
                ladder.build(3, 2);
                assertThat(ladder.getTotalFootStepCount()).isEqualTo(6);
            }
        }
    }
}