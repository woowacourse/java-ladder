package laddergame.model;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ResultProcessorTest {
    @DisplayName("결과 처리기를 생성한다.")
    @Test
    void createTest() {
        Participants participants = createParticipants();
        ExecutionResults executionResults = createExecutionResults(participants);
        LadderGame ladderGame = getLadderGame();
        InquirySubject inquirySubject = new InquirySubject(new Participant("all"), participants);

        assertThatCode(() -> new ResultProcessor(inquirySubject, executionResults, ladderGame))
                .doesNotThrowAnyException();
    }

    @DisplayName("사다리 게임 결과를 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {"all,4", "daon,1"})
    void getGameResult(String subjectName, int expected) {
        Participants participants = createParticipants();
        ExecutionResults executionResults = createExecutionResults(participants);
        InquirySubject inquirySubject = new InquirySubject(new Participant(subjectName), participants);
        LadderGame ladderGame = getLadderGame();

        ResultProcessor resultProcessor = new ResultProcessor(inquirySubject, executionResults, ladderGame);
        List<GameResult> gameResults = resultProcessor.getGameResults();
        assertThat(gameResults).hasSize(expected);
    }

    private Participants createParticipants() {
        return Stream.of("daon", "mason", "ted", "jk")
                .map(Participant::new)
                .collect(collectingAndThen(toList(), Participants::new));
    }

    private ExecutionResults createExecutionResults(Participants participants) {
        return Stream.of("꽝", "당첨", "꽝", "청소")
                .map(ExecutionResult::new)
                .collect(collectingAndThen(toList(), results -> new ExecutionResults(results, participants)));
    }

    private LadderGame getLadderGame() {
        return new LadderGame(
                List.of(new Line(List.of(LineState.START, LineState.END, LineState.NONE, LineState.NONE))));
    }
}
