package domain;

import domain.ladder.Ladder;
import domain.ladder.attirbute.Direction;
import domain.player.Players;

import java.util.List;

public class GameBoard {
    private final Players players;
    private final Ladder ladder;

    public GameBoard(Players players, Ladder ladder) {
        this.players = players;
        this.ladder = ladder;
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

    public List<Direction> getDirectionAtHorizontalIndex(Integer index) {
        return ladder.getDirectionAtHorizontalIndex(index);
    }
}
