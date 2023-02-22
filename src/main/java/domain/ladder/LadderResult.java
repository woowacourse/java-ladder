package domain.ladder;

public class LadderResult {

    private static final int MAX_RESULT_LENGTH = 5;

    private final String result;

    public LadderResult(String result) {
        validate(result);
        this.result = result;
    }

    private void validate(String result) {
        if (result.isBlank()) {
            throw new IllegalArgumentException(String.format("결과는 공백이거나 비어있을 수 없습니다. 입력값 : %s", result));
        }

        if (result.length() > MAX_RESULT_LENGTH) {
            throw new IllegalArgumentException(String.format("결과는 1글자 이상, 5글자 이하여야합니다. 입력값 : %s", result));
        }
    }

    public String getResult() {
        return result;
    }
}
