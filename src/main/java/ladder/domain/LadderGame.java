package ladder.domain;

import ladder.domain.ladderNode.Players;
import ladder.domain.ladderNode.Results;
import ladder.dto.ResultDto;
import ladder.utils.LineStrategy;

import java.util.List;

public class LadderGame {
    private final Ladder ladder;
    private final Players players;
    private final Results results;

    public LadderGame(Command command, LineStrategy lineStrategy) {
        this.players = new Players(command.getNames());
        this.ladder = new Ladder(command.getWidth(), command.getHeight(), lineStrategy);
        this.results = new Results(command.getResults());
    }

    public List<ResultDto> calculatePlayerResult(String playerName, String queryAll) {
        if (playerName.equals(queryAll)) {
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
