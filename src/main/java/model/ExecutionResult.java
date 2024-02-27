package model;

import java.util.List;

public class ExecutionResult {
    private final List<String> executionResult;

    public ExecutionResult(List<String> executionResult, int participantsSize) {
        validator(executionResult, participantsSize);
        this.executionResult = executionResult;
    }

    private void validator(List<String> executionResult, int participantsSize) {
        if (executionResult.size() != participantsSize) {
            throw new IllegalArgumentException("실행 결과는 참여할 사람 수만큼 있어야 한다");
        }
    }

    public List<String> getExecutionResult() {
        return executionResult;
    }
}
