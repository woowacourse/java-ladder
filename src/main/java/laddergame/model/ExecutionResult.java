package laddergame.model;

public class ExecutionResult {
    private final String name;

    public ExecutionResult(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("실행 결과는 공백일 수 없습니다.");
        }
    }
}
