package domain;

import java.util.HashMap;
import java.util.Map;

public class LadderGame {

    private final Ladder ladder;
    private final Players players;
    private final Prizes prizes;
    private final Map<Player, Prize> result;

    public LadderGame(Ladder ladder, Players players, Prizes prizes) {
        this.ladder = ladder;
        this.players = players;
        this.prizes = prizes;
        this.result = new HashMap<>();
    }

    public Map<Player, Prize> run() {
        if (isDone()) {
            return result;
        }
        play();
        finish();
        return result;
    }

    private boolean isDone() {
        return !result.isEmpty();
    }

    private void finish() {
        for (Player player : players.getPlayers()) {
            int position = player.getPosition();
            result.put(player, prizes.getOnePrizeByIndex(position));
        }
    }

    private void play() {
        for (Line line : ladder.getLadder()) {
            players.move(line);
        }
    }

    public Ladder getLadder() {
        return ladder;
    }

    public Players getPlayers() {
        return players;
    }

    public Prizes getPrizes() {
        return prizes;
    }
}
