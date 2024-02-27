package laddergame.model;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ExecutionResultsTest {
    @DisplayName("실행 결과 수가 참가자 수와 동일하지 않는 경우 예외를 발생한다.")
    @Test
    void validateSameCountWithParticipants() {
        List<ExecutionResult> executionResults = Stream.of("1", "2", "3", "4")
                .map(ExecutionResult::new)
                .toList();
        Participants participants = Stream.of("daon", "ash", "dao", "ted", "12")
                .map(Participant::new)
                .collect(collectingAndThen(toList(), Participants::new));

        assertThatThrownBy(() -> new ExecutionResults(executionResults, participants))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
