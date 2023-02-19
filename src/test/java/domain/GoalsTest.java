package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@DisplayName("사다리 도착 결과들은 ")
class GoalsTest {
    @Nested
    @DisplayName("저장할 때 ")
    class GeneratingCase {
        @Test
        @DisplayName("앞서 저장한 사람 수와 동일한 수만큼 입력하면 정상 작동한다.")
        void givenGoalsAndParticipantsSize_thenReturnsGoals() {
            int participantsSize = 4;
            List<String> goalNames = List.of("5000", "꽝", "30000", "0");

            assertDoesNotThrow(() -> Goals.of(participantsSize, goalNames));
        }

        @Test
        @DisplayName("앞서 저장한 사람 수와 다른 수만큼 입력하면 예외가 발생한다.")
        void givenGoalsSizeDifferentFromParticipantsSize_thenThrowsException() {
            int participantsSize = 3;
            List<String> goalNames = List.of("5000", "꽝", "30000", "0");

            assertThatThrownBy(() -> Goals.of(participantsSize, goalNames))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(Goals.DIFFERENT_FROM_PARTICIPANTS_SIZE_ERROR_MESSAGE);
        }
    }
}