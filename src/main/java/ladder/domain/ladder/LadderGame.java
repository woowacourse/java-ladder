package ladder.domain.ladder;

import ladder.domain.player.Name;
import ladder.domain.player.Players;
import ladder.domain.result.PlayResults;
import ladder.domain.result.Result;
import ladder.domain.result.Results;

import java.util.LinkedHashMap;
import java.util.Map;

public class LadderGame {

    private final Players players;
    private final Results results;
    private final Ladder ladder;

    public LadderGame(Players players, Results results, Ladder ladder) {
        this.players = players;
        this.results = results.refactor(players.count());
        this.ladder = ladder;
    }

    public PlayResults play(Name name) {
        if (name.isAll()) {
            return playAll();
        }
        Result result = playOne(name);
        return new PlayResults(Map.of(name, result));
    }

    private Result playOne(Name name) {
        int startPosition = players.findPosition(name);
        int resultPosition = ladder.ride(startPosition);
        return results.find(resultPosition);
    }

    private PlayResults playAll() {
        Map<Name, Result> results = new LinkedHashMap<>();
        for (Name name : players.getNames()) {
            Result result = playOne(name);
            results.put(name, result);
        }
        return new PlayResults(results);
    }

    public Players getPlayers() {
        return players;
    }

    public Results getResults() {
        return results;
    }

    public Ladder getLadder() {
        return ladder;
    }
}
