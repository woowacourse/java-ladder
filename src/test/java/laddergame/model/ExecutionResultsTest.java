package laddergame.model;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ExecutionResultsTest {
    @Test
    @DisplayName("올바른 값이 들어오면 오류가 발생하지 않는다.")
    void Should_Success_When_ResultsInput() {
        int participantsNumber = 4;
        assertDoesNotThrow(() -> new ExecutionResults(List.of("꽝", "5000", "1000", "3000"), participantsNumber));
    }

    @Test
    @DisplayName("결과는 중복될 수 있다.")
    void Should_Success_When_DuplicateResultsInput() {
        int participantsNumber = 4;
        assertDoesNotThrow(() -> new ExecutionResults(List.of("꽝", "5000", "꽝", "3000"), participantsNumber));
    }

    @Test
    @DisplayName("실행결과의 개수는 참여자의 명수와 같지 않으면 오류를 발생한다.")
    void Should_ThrowException_When_NotEqualsSizeOfExecutionResultsAndParticipants() {
        Participants participants = new Participants(List.of("name1", "name2", "name3"));
        assertThatThrownBy(() -> new ExecutionResults(List.of("꽝", "5000", "꽝", "3000"), participants.getNumber()))
            .isExactlyInstanceOf(IllegalArgumentException.class);
    }
}
