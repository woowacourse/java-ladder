package domain;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class GameResultDto {

    private final HashMap<Member, Reward> gameResult;

    public GameResultDto(HashMap<Member, Reward> gameResult) {
        this.gameResult = new LinkedHashMap<>(gameResult);
    }

    public HashMap<Member, Reward> getGameResult() {
        return gameResult;
    }
}
