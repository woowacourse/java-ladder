package domain;

import domain.ladder.Ladder;
import domain.player.Player;
import domain.player.Players;
import domain.result.Result;
import domain.result.Results;

import java.util.LinkedHashMap;
import java.util.Map;

public class LadderGame {

    private final Map<Player, Result> playerResult = new LinkedHashMap<>();

    public LadderGame(Players players, Ladder ladder, Results results) {
        play(players, ladder, results);
    }

    public Map<Player, Result> play(Players players, Ladder ladder, Results results) {
        for (int i = 0; i < players.getPlayerSize(); i++) {
            int destination = ladder.climbLines(i);
            playerResult.put(players.getPlayers().get(i), results.getResults().get(destination));
        }
        return this.playerResult;
    }
}
