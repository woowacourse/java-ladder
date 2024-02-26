package domain;

public class LadderResult {

    private static final int MIN_LENGTH = 1;
    private static final int MAX_LENGTH = 5;

    private final String result;

    public LadderResult(String result) {
        validateLength(result);
        this.result = result;
    }

    public String getResult() {
        return result;
    }

    private void validateLength(String result) {
        if (isInvalidLengthName(result)) {
            throw new IllegalArgumentException("[ERROR] 결과의 길이는 " + MIN_LENGTH + "자에서 " + MAX_LENGTH + "자 사이여야 합니다");
        }
    }

    private boolean isInvalidLengthName(String result) {
        return result.length() < MIN_LENGTH || result.length() > MAX_LENGTH;
    }
}

