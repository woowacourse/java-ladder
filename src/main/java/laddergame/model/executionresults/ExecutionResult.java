package laddergame.model.executionresults;

public class ExecutionResult {
    private final String name;

    public ExecutionResult(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        if (name == null || name.isBlank()) {
            String message = "[ERROR] 실행 결과는 공백일 수 없습니다. 입력값: " + name;
            throw new IllegalArgumentException(message);
        }
    }

    public String getName() {
        return name;
    }
}
