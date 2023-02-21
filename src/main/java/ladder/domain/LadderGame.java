package ladder.domain;

import ladder.dto.ResultDto;
import ladder.utils.LineStrategy;

import java.util.List;

public class LadderGame {
    public static final String QUERY_ALL = "all";
    private final Ladder ladder;
    private final Players players;
    private final Results results;

    public LadderGame(Command command, LineStrategy lineStrategy) {
        this.players = new Players(command.getNames());
        this.ladder = new Ladder(command.getWidth(), command.getHeight(), lineStrategy);
        this.results = new Results(command.getResults());
    }

    public List<ResultDto> calculatePlayerResult(String playerName) {
        if (playerName.equals(QUERY_ALL)) {
            return results.getResultsByPosition(players.moveAllToResult(ladder));
        }
        return results.getResultsByPosition(players.moveToResult(playerName, ladder));
    }

    public List<List<Boolean>> getLadder() {
        return ladder.getLines();
    }

    public List<String> getPlayerNames() {
        return players.getPlayerNames();
    }

    public List<String> getResults() {
        return results.getResults();
    }
}
