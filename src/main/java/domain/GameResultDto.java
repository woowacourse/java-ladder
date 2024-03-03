package domain;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class GameResultDto {

    private final HashMap<Member, Result> gameResult;

    public GameResultDto(HashMap<Member, Result> gameResult) {
        this.gameResult = new LinkedHashMap<>(gameResult);
    }

    public HashMap<Member, Result> getGameResult() {
        return gameResult;
    }
}
