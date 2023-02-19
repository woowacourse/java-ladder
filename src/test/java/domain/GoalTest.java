package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@DisplayName("사다리 도착 결과는 ")
class GoalTest {
    @Nested
    @DisplayName("저장할 때 ")
    class GeneratingCase {
        @Test
        @DisplayName("최소 한 글자부터 입력받을 수 있다.")
        void givenMinGoalLength_thenReturnsGoal() {
            String name = "골";

            assertDoesNotThrow(() -> Goal.of(name));
        }

        @Test
        @DisplayName("최소 한 글자보다도 작은 값일 경우 예외가 발생한다.")
        void givenLessThanMinGoalLength_thenThrowsException() {
            String name = "";

            assertThatThrownBy(() -> Goal.of(name))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(Goal.MIN_LENGTH_ERROR_MESSAGE);
        }

        @Test
        @DisplayName("최대 다섯 글자까지 입력받을 수 있다.")
        void givenMaxGoalLength_thenReturnsGoal() {
            String name = "50000";

            assertDoesNotThrow(() -> Goal.of(name));
        }

        @Test
        @DisplayName("최대 다섯 글자보다 큰 값일 경우 예외가 발생한다.")
        void givenOverThanMaxGoalLength_thenThrowsException() {
            String name = "500000";

            assertThatThrownBy(() -> Goal.of(name))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(Goal.MAX_LENGTH_ERROR_MESSAGE);
        }
    }
}