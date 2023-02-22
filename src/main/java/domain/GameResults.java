package domain;

import java.util.List;
import java.util.Objects;

public class GameResults {

    public GameResults(int playerSize, List<String> results) {
        validateNullAndEmpty(results);
        validateSize(playerSize, results);
    }

    private void validateNullAndEmpty(List<String> results) {
        if (Objects.isNull(results) || results.isEmpty()) {
            throw new IllegalArgumentException("실행 결과를 입력하세요.");
        }
    }

    private static void validateSize(int playerSize, List<String> results) {
        if (results.size() != playerSize) {
            throw new IllegalArgumentException("실행 결과 개수는 플레이어 수와 일치해야 합니다.");
        }
    }
}
