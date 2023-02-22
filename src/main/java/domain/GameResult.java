package domain;

import java.util.List;
import java.util.Objects;

public class GameResult {

    public GameResult(String resultInput) {
        validateNullAndEmpty(resultInput);
    }

    public GameResult(int playerSize, List<String> results) {
        validateResultSize(playerSize, results);
    }

    private void validateResultSize(int playerSize, List<String> results) {
        if (results.size() != playerSize) {
            throw new IllegalArgumentException("플레이어의 수와 실행 결과 수는 일치해야 합니다.");
        }
    }

    private void validateNullAndEmpty(String resultInput) {
        if (Objects.isNull(resultInput) || resultInput.isBlank()) {
            throw new IllegalArgumentException("한 개 이상의 실행 결과를 입력해야 합니다.");
        }
    }
}
