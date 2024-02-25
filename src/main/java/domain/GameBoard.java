package domain;

import domain.ladder.Ladder;
import domain.ladder.attirbute.Direction;
import domain.player.Players;

import java.util.List;

public class GameBoard {
    private final Players players;
    private final Ladder ladder;
    private final Prizes prizes;

    public GameBoard(Players players, Ladder ladder, Prizes prizes) {
        this.players = players;
        this.ladder = ladder;
        this.prizes = prizes;
    }

    public Players getPlayers() {
        return players;
    }

    public int getLadderHeight() {
        return ladder.getHeight();
    }

    public Ladder getLadder() {
        return ladder;
    }

    public Prizes getPrizes() {
        return prizes;
    }

    public List<Direction> getDirectionAtHorizontalIndex(Integer index) {
        return ladder.getDirectionAtHorizontalIndex(index);
    }
}
