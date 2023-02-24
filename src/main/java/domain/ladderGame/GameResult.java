package domain.ladderGame;

import java.util.LinkedHashMap;

public class GameResult {

    private final LinkedHashMap<String, String> gameResult;

    public GameResult(LinkedHashMap<String, String> gameResult) {
        this.gameResult = gameResult;
    }

    public LinkedHashMap<String, String> getGameResult() {
        return gameResult;
    }
}
