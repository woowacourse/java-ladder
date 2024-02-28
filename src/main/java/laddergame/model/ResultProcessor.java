package laddergame.model;

import java.util.List;

public class ResultProcessor {
    private final InquirySubject inquirySubject;
    private final ExecutionResults executionResults;
    private final LadderGame ladderGame;

    public ResultProcessor(InquirySubject inquirySubject, ExecutionResults executionResults,
                           LadderGame ladderGame) {
        this.inquirySubject = inquirySubject;
        this.executionResults = executionResults;
        this.ladderGame = ladderGame;
    }

    public List<GameResult> getGameResults() {
        List<Integer> subjectIndex = inquirySubject.getSubjectIndex();
        List<Integer> changedIndexes = subjectIndex.stream()
                .map(ladderGame::climb)
                .toList();
        return subjectIndex.stream()
                .map(index -> getGameResult(index, changedIndexes))
                .toList();
    }

    private GameResult getGameResult(Integer index, List<Integer> changedIndexes) {
        Participant participant = inquirySubject.getParticipantByIndex(index);
        ExecutionResult executionResult = executionResults.findByIndex(changedIndexes.get(index));
        return new GameResult(participant, executionResult);
    }
}
