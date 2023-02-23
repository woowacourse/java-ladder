package domain.service;

import domain.model.Ladder;
import domain.model.Players;
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

    public List<String> resultsByNames(List<String> names) {
        List<String> res = new ArrayList<>();
        for (String name : names) {
            res.add(resultByName(name));
        }
        return List.copyOf(res);
    }

    private String resultByName(String name) {
        int order = players.orderByName(name);
        return results.get(order);
    }

    public Players getPlayers() {
        return players;
    }
}
