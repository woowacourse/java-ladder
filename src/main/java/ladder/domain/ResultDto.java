package ladder.domain;

import java.util.List;

public class ResultDto {

    private final List<String> playerNames;
    private final List<String> gameResult;

    public ResultDto(List<String> playerNames, List<String> gameResult) {
        this.playerNames = List.copyOf(playerNames);
        this.gameResult = List.copyOf(gameResult);
    }

    public List<String> getPlayerNames() {
        return playerNames;
    }

    public List<String> getGameResult() {
        return gameResult;
    }
}
