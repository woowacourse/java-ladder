package ladder.domain;

import ladder.domain.ladderNode.Name;
import ladder.domain.ladderNode.Players;
import ladder.domain.ladderNode.Position;
import ladder.domain.ladderNode.Results;
import ladder.dto.ResultDto;

import java.util.List;
import java.util.Map;

public class LadderGame {
    private final Ladder ladder;
    private final Players players;
    private final Results results;

    private LadderGame(Ladder ladder, Players players, Results results) {
        this.ladder = ladder;
        this.players = players;
        this.results = results;
    }

    public static LadderGame of(Ladder ladder, Players players, Results results) {
        return new LadderGame(ladder, players, results);
    }

    public List<ResultDto> play(String playerName, String queryAll) {
        if (playerName.equals(queryAll)) {
            return allPlayerResults();
        }
        return onePlayerResult(playerName);
    }

    private List<ResultDto> allPlayerResults() {
        Map<Position, String> arrivePosition = players.moveAllToLadderEnd(ladder);
        return results.getResultsByPosition(arrivePosition);
    }

    private List<ResultDto> onePlayerResult(String playerName) {
        Map<Position, String> arrivePosition = players.moveToLadderEnd(new Name(playerName), ladder);
        return results.getResultsByPosition(arrivePosition);
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
