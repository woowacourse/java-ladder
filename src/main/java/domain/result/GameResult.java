package domain.result;

import java.util.Map;

public class GameResult {

    private final Map<String, String> gameResult;

    public GameResult(Map<String, String> gameResult) {
        this.gameResult = gameResult;
    }

    public String findByName(String name) {
        if (!gameResult.containsKey(name)) {
            throw new IllegalArgumentException("이름과 일치하는 참가자가 존재하지 않습니다.");
        }
        return gameResult.get(name);
    }

    public boolean contains(String name) {
        return gameResult.containsKey(name);
    }

    public Map<String, String> getGameResult() {
        return gameResult;
    }
}
