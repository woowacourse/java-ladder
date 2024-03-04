package laddergame.model.executionresults;

import laddergame.exception.BaseException;

public record ExecutionResult(String name) {
    public ExecutionResult {
        validateName(name);
    }

    private void validateName(String name) {
        if (name == null || name.isBlank()) {
            String message = "실행 결과는 공백일 수 없습니다. 입력값: " + name;
            throw new BaseException(message);
        }
    }
}
