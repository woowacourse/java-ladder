package domain;

import java.util.HashMap;
import java.util.Map;

public class LadderGame {

    private final Ladder ladder;
    private final Players players;
    private final Prize prize;
    private final Map<String, String> result;

    public LadderGame(Ladder ladder, Players players, Prize prize) {
        this.ladder = ladder;
        this.players = players;
        this.prize = prize;
        this.result = new HashMap<>();
    }

    public Map<String, String> run() {
        if (!isDone()) {
            return result;
        }
        play();
        finish();
        return result;
    }

    private boolean isDone() {
        return !result.isEmpty();
    }

    private Map<String, String> finish() {
        for (Player player : players.getPlayers()) {
            int position = player.getPosition();
            result.put(player.getName(), prize.getOnePrizeByIndex(position));
        }
        return result;
    }

    private void play() {
        for (Line line : ladder.getLadder()) {
            players.move(line);
        }
    }
}
