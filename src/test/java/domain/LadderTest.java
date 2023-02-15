package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

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

}