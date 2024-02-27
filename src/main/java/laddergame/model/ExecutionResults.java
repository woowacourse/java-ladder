package laddergame.model;

import java.util.List;

public class ExecutionResults {
    private final List<ExecutionResult> executionResults;

    public ExecutionResults(List<ExecutionResult> executionResults, Participants participants) {
        validateExecutionResultsSize(executionResults, participants);
        this.executionResults = executionResults;
    }

    private void validateExecutionResultsSize(List<ExecutionResult> executionResults, Participants participants) {
        if (executionResults.size() != participants.getSize()) {
            String message = "실행 결과는 참여자수와 동일해야합니다. 참여자수:" + participants.getSize()
                    + "실행 결과 수:" + executionResults.size();
            throw new IllegalArgumentException(message);
        }
    }
}
