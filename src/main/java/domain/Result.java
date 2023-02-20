package domain;

public class Result {

    private final String result;

    public Result(final String result) {
        validateRangeOfValue(result);
        this.result = result;
    }

    private void validateRangeOfValue(final String result) {
        if (result.length() < 1 || result.length() > 5) {
            throw new IllegalArgumentException("결과 값의 길이는 1이상 5이하만 가능합니다.");
        }
    }

    public String getResult() {
        return this.result;
    }
}
