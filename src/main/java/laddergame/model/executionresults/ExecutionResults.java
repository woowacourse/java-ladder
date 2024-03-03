package laddergame.model.executionresults;

import java.util.List;
import laddergame.exception.BaseException;
import laddergame.model.participants.Participants;

public class ExecutionResults {
    private final List<ExecutionResult> executionResults;

    public ExecutionResults(List<ExecutionResult> executionResults, Participants participants) {
        validateExecutionResultsSize(executionResults, participants);
        this.executionResults = executionResults;
    }

    private void validateExecutionResultsSize(List<ExecutionResult> executionResults, Participants participants) {
        if (executionResults.size() != participants.getSize()) {
            String message = "실행 결과는 참여자수와 동일해야합니다. 참여자수:" + participants.getSize() + ", "
                    + "입력한 실행 결과 수:" + executionResults.size();
            throw new BaseException(message);
        }
    }

    public ExecutionResult findByIndex(int index) {
        if (index < 0 || index >= executionResults.size()) {
            throw new BaseException("비정상적인 인덱싱 조회입니다.");
        }
        return executionResults.get(index);
    }

    public List<ExecutionResult> getExecutionResults() {
        return executionResults;
    }
}
