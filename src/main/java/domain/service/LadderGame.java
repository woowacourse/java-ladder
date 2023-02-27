package domain.service;

import domain.model.Ladder;
import domain.model.Players;
import domain.vo.Names;
import domain.vo.Results;

import java.util.ArrayList;
import java.util.List;

public class LadderGame {
    private final Ladder ladder;
    private final Players players;
    private final Results results;

    public LadderGame(Ladder ladder, Players players, Results results) {
        this.ladder = ladder;
        this.players = players;
        this.results = results;
    }

    public void play() {
        for (int i = 0; i < ladder.getHeight(); i++) {
            players.moveAll(ladder);
        }
    }

    public Results resultsByNames(Names names) {
        List<Integer> order = names.orderByName(players);
        List<String> orderedResults = new ArrayList<>();
        for (Integer integer : order) {
            orderedResults.add(results.get(integer).getValue());
        }
        return Results.from(orderedResults);
    }

    public Players getPlayers() {
        return players;
    }

    public List<String> allPlayersName() {
        return players.mapToString();
    }
}
