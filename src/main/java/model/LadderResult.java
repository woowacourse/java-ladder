package model;

public class LadderResult {

    private final String result;

    public LadderResult(String result) {
        validateBlank(result);
        this.result = result;
    }

    private void validateBlank(String result) {
        if (result.isBlank()) {
            throw new IllegalArgumentException("실행 결과는 공백일 수 없습니다.");
        }
    }

    public String getResult() {
        return result;
    }
}
