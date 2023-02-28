package domain;

import domain.ladder.Ladder;
import domain.ladder.Line;
import domain.player.Player;
import domain.player.Players;
import domain.prize.Prizes;
import domain.prize.Results;

public class LadderGame {

    private final Ladder ladder;
    private final Players players;
    private final Prizes prizes;
    private final Results results;


    public LadderGame(Ladder ladder, Players players, Prizes prizes) {
        this.ladder = ladder;
        this.players = players;
        this.prizes = prizes;
        this.results = new Results();
    }

    public Results run() {
        if (isDone()) {
            return results;
        }
        play();
        finish();
        return results;
    }

    private boolean isDone() {
        return results.isSameSizeAs(players.getPlayerSize());
    }

    private void finish() {
        for (final Player player : players.getPlayers()) {
            int position = player.getPosition();
            results.addResult(player, prizes.getOnePrizeByIndex(position));
        }
    }

    private void play() {
        for (final Line line : ladder.getLadder()) {
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
