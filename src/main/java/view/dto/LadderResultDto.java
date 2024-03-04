package view.dto;

import java.util.List;

public class LadderResultDto {

    private final List<String> playerNames;
    private final List<List<Boolean>> lines;
    private final List<String> resultNames;

    public LadderResultDto(List<String> playerNames, List<List<Boolean>> lines, List<String> resultNames) {
        this.playerNames = playerNames;
        this.lines = lines;
        this.resultNames = resultNames;
    }

    public static LadderResultDto of(List<String> playerNames, List<List<Boolean>> lines, List<String> results) {
        return new LadderResultDto(playerNames, lines, results);
    }


    public List<String> getPlayerNames() {
        return playerNames;
    }

    public List<List<Boolean>> getLines() {
        return lines;
    }

    public List<String> getResultNames() {
        return resultNames;
    }
}
