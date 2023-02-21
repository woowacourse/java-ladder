package ladder.domain;

import java.util.List;

public class ResultDto {

    private final List<String> playerNames;
    private final List<String> gameResult;
    private final Boolean stop;

    public ResultDto(final List<String> playerNames, final List<String> gameResult, Boolean stop) {
        this.playerNames = List.copyOf(playerNames);
        this.gameResult = List.copyOf(gameResult);
        this.stop = stop;
    }

    public List<String> getPlayerNames() {
        return playerNames;
    }

    public List<String> getGameResult() {
        return gameResult;
    }

    public Boolean isStop() {
        return stop;
    }
}
