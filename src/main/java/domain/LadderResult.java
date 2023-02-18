package domain;

public class LadderResult {

    private final String result;

    public LadderResult(final String result) {
        validate(result);
        this.result = result;
    }

    // todo: Exception 메시지 채우기
    private void validate(final String result) {
        if (result.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    public int getLengthOfLadderResult() {
        return this.result.length();
    }

    public String getResult() {
        return result;
    }
}
