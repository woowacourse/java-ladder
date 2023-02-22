package domain;

import java.util.Objects;

public class GameResult {

    public GameResult(String resultInput) {
        validateNullAndEmpty(resultInput);
    }

    private void validateNullAndEmpty(String resultInput) {
        if (Objects.isNull(resultInput) || resultInput.isBlank()) {
            throw new IllegalArgumentException("한 개 이상의 실행 결과를 입력해야 합니다.");
        }
    }
}
