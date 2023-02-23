package domain;

import java.util.HashMap;
import java.util.Map;

public class LadderGame {

    private final Ladder ladder;
    private final Players players;

    private final Map<String, Integer> result;

    public LadderGame(Ladder ladder, Players players) {
        this.ladder = ladder;
        this.players = players;
        result = new HashMap<>();
    }

    public Map<String, Integer> run() {
        if (!result.isEmpty()) {
            return result;
        }
        for (Line line: ladder.getLadder()) {
            players.move(line);
        }
        for (Player player: players.getPlayers()) {
            result.put(player.getName(), player.getPosition());
        }
        return result;
    }
}
