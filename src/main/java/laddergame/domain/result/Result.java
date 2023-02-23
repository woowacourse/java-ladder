package laddergame.domain.result;

public class Result {

    private final String result;

    public Result(final String result) {
        validateNullOrEmpty(result);
        this.result = result;
    }

    private void validateNullOrEmpty(final String result) {
        if (result == null || result.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 실행 결과는 null 이거나 빈 값일 수 없습니다.");
        }
    }
}
