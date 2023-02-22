package domain;

import java.util.List;

public class GameResults {

    public GameResults(int playerSize, List<String> results) {
        if (results.size() != playerSize) {
            throw new IllegalArgumentException("실행 결과 개수는 플레이어 수와 일치해야 합니다.");
        }
    }
}
