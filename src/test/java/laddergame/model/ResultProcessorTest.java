package laddergame.model;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ResultProcessorTest {
    @DisplayName("단일 사다리 게임 결과를 반환한다.")
    @ParameterizedTest
    @MethodSource("createLadderGameAndSingleIndex")
    void getGameResult(LadderGame ladderGame, int changedIndex) {
        Participants participants = createParticipants();
        ExecutionResults executionResults = createExecutionResults(participants);
        InquirySubject inquirySubject = new InquirySubject(new Participant("daon"), participants);

        ResultProcessor resultProcessor = new ResultProcessor(inquirySubject, executionResults, ladderGame);
        List<GameResult> gameResults = resultProcessor.getGameResults();
        assertThat(gameResults).hasSize(1);
        assertThat(gameResults.get(0).getExecutionResult()).isEqualTo(executionResults.findByIndex(changedIndex));
    }

    @DisplayName("전체 사다리 게임 결과를 반환한다.")
    @ParameterizedTest
    @MethodSource("createLadderGameAndAllIndex")
    void getGameResultAll(LadderGame ladderGame, List<Integer> changedIndexes) {
        Participants participants = createParticipants();
        ExecutionResults executionResults = createExecutionResults(participants);
        InquirySubject inquirySubject = new InquirySubject(new Participant("all"), participants);

        ResultProcessor resultProcessor = new ResultProcessor(inquirySubject, executionResults, ladderGame);
        List<GameResult> gameResults = resultProcessor.getGameResults();
        assertAll(
                () -> assertThat(gameResults.get(0).getExecutionResult())
                        .isEqualTo(executionResults.findByIndex(changedIndexes.get(0))),
                () -> assertThat(gameResults.get(1).getExecutionResult())
                        .isEqualTo(executionResults.findByIndex(changedIndexes.get(1))),
                () -> assertThat(gameResults.get(2).getExecutionResult())
                        .isEqualTo(executionResults.findByIndex(changedIndexes.get(2))),
                () -> assertThat(gameResults.get(3).getExecutionResult())
                        .isEqualTo(executionResults.findByIndex(changedIndexes.get(3)))
        );
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

    private static Stream<Arguments> createLadderGameAndSingleIndex() {
        return Stream.of(
                Arguments.arguments(
                        new LadderGame(List.of(
                                new Line(List.of(LineState.START, LineState.END, LineState.NONE, LineState.NONE)),
                                new Line(List.of(LineState.NONE, LineState.NONE, LineState.NONE, LineState.NONE)),
                                new Line(List.of(LineState.NONE, LineState.START, LineState.END, LineState.NONE))
                        )), 2),
                Arguments.arguments(
                        new LadderGame(List.of(
                                new Line(List.of(LineState.START, LineState.END, LineState.START, LineState.END)),
                                new Line(List.of(LineState.START, LineState.END, LineState.NONE, LineState.NONE)),
                                new Line(List.of(LineState.NONE, LineState.NONE, LineState.NONE, LineState.NONE)),
                                new Line(List.of(LineState.START, LineState.END, LineState.NONE, LineState.NONE))
                        )), 1),
                Arguments.arguments(
                        new LadderGame(List.of(
                                new Line(List.of(LineState.NONE, LineState.NONE, LineState.START, LineState.END)),
                                new Line(List.of(LineState.NONE, LineState.NONE, LineState.NONE, LineState.NONE))
                        )), 0)
        );
    }

    private static Stream<Arguments> createLadderGameAndAllIndex() {
        return Stream.of(
                Arguments.arguments(
                        new LadderGame(List.of(
                                new Line(List.of(LineState.START, LineState.END, LineState.NONE, LineState.NONE)),
                                new Line(List.of(LineState.NONE, LineState.NONE, LineState.NONE, LineState.NONE)),
                                new Line(List.of(LineState.NONE, LineState.START, LineState.END, LineState.NONE))
                        )),
                        List.of(2, 0, 1, 3)
                ),
                Arguments.arguments(
                        new LadderGame(List.of(
                                new Line(List.of(LineState.START, LineState.END, LineState.START, LineState.END)),
                                new Line(List.of(LineState.START, LineState.END, LineState.NONE, LineState.NONE)),
                                new Line(List.of(LineState.NONE, LineState.NONE, LineState.NONE, LineState.NONE)),
                                new Line(List.of(LineState.START, LineState.END, LineState.NONE, LineState.NONE))
                        )),
                        List.of(1, 0, 3, 2)
                ),
                Arguments.arguments(
                        new LadderGame(List.of(
                                new Line(List.of(LineState.NONE, LineState.NONE, LineState.START, LineState.END)),
                                new Line(List.of(LineState.NONE, LineState.NONE, LineState.NONE, LineState.NONE))
                        )), List.of(0, 1, 3, 2)
                )
        );
    }
}
