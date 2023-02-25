package domain;

import java.util.Objects;

public class GameResult {

    public static final int MIN_RESULT_NAME_SIZE = 1;
    public static final int MAX_RESULT_NAME_SIZE = 5;

    private final String result;

    public GameResult(String result) {
        validate(result);
        this.result = result;
    }

    private void validate(String result) {
        validateNullAndEmpty(result);
        validateResultNameSize(result);
    }

    private void validateNullAndEmpty(String resultInput) {
        if (Objects.isNull(resultInput) || resultInput.isBlank()) {
            throw new IllegalArgumentException("한 개 이상의 실행 결과를 입력해야 합니다.");
        }
    }

    private void validateResultNameSize(String result) {
        if (result.length() < MIN_RESULT_NAME_SIZE || result.length() > MAX_RESULT_NAME_SIZE) {
            throw new IllegalArgumentException("게임 실행 결과는 한 글자 이상 다섯글자 이하로 입력 가능합니다.");
        }
    }

    public String getResult() {
        return result;
    }

}
