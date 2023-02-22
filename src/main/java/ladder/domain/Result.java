package ladder.domain;

public class Result {
    private final String result;

    public Result(String result) {
        validate(result);
        this.result = result;
    }

    private void validate(String result) {
        validateNull(result);
        validateEmpty(result);
    }

    private void validateEmpty(String result) {
        if (result.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 결과는 공백일 수 없습니다.");
        }
    }

    private void validateNull(String result) {
        if (result == null) {
            throw new IllegalArgumentException("[ERROR] 이름에 null이 들어갈 수 없습니다.");
        }
    }

    public String getResult() {
        return result;
    }
}
