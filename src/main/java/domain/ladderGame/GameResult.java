package domain.ladderGame;

import java.util.LinkedHashMap;

public class GameResult {

    private final LinkedHashMap<String, String> gameResult;

    public GameResult(LinkedHashMap<String, String> gameResult) {
        this.gameResult = gameResult;
    }

    public String getTargetResult(String target) {
        return gameResult.get(target);
    }

    public LinkedHashMap<String, String> getGameResult() {
        return gameResult;
    }
}
