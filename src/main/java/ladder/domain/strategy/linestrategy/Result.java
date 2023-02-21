package ladder.domain.strategy.linestrategy;

public class Result {
    private final String result;

    public Result(String result) {
        validateEmpty(result);
        this.result = result;
    }

    private void validateEmpty(String result) {
        if (result.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 결과는 공백일 수 없습니다.");
        }
    }
}
