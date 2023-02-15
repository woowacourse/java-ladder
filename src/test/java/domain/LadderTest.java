package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
@DisplayName("사다리는 ")
class LadderTest {
    @Nested
    @DisplayName("생성될 때 ")
    class GenerateCase {
        @Nested
        class SuccessCase {
            @Test
            @DisplayName(" 높이가 2이면 생성된다.")
            void giveTwoHeight_thenThrowsException() {
                assertThatCode(() -> new Ladder(2))
                        .doesNotThrowAnyException();
            }

            @Test
            @DisplayName(" 높이가 10이면 생성된다.")
            void givenTenHeight_thenThrowsException() {
                assertThatCode(() -> new Ladder(10))
                        .doesNotThrowAnyException();
            }
        }

        @Nested
        class FailureCase {
            @Test
            @DisplayName(" 높이가 1이면 익셉션이 발생한다.")
            void givenOneHeight_thenThrowsException() {
                assertThatThrownBy(() -> new Ladder(1))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("사다리 높이는 2 이상이어야 합니다.");
            }

            @Test
            @DisplayName(" 높이가 11이면 익셉션이 발생한다.")
            void givenElevenHeight_thenThrowsException() {
                assertThatThrownBy(() -> new Ladder(11))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("사다리 높이는 10 이하여야 합니다.");
            }
        }
    }

    @Nested
    @DisplayName("다리를 만들 때 ")
    class GenerateLineCase{
        @Disabled
        @ParameterizedTest
        @DisplayName("정상적인 높이면 해당 높이만큼 다리를 생성한다.")
        @ValueSource(ints = {2,3,4,5,6,7,8,9,10})
        void givenValidHeight_thenBuildLines(final int height){
            Ladder ladder = new Ladder();
            ladder.build(height);
            Assertions.assertThat(ladder.getLineHeight()).isEqualTo(height);
        }

        @ParameterizedTest
        @DisplayName("비정상적인 높이면 익셉션을 발생한다.")
        @ValueSource(ints = {0,1,11,12})
        void givenInValidHeight_thenThrowException(final int height){
            Ladder ladder = new Ladder();

            Assertions.assertThatThrownBy(() -> ladder.build(height))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("사다리 길이는 2에서 10사이여야 합니다.");
        }
    }

}