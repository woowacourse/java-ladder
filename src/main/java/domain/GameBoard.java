package domain;

import domain.ladder.Ladder;
import domain.ladder.common.Direction;
import domain.player.Players;

import java.util.List;

public class GameBoard {
    private final Players players;
    private final Ladder ladder;
    private final Rewards rewards;

    public GameBoard(Players players, Ladder ladder, Rewards rewards) {
        this.players = players;
        this.ladder = ladder;
        this.rewards = rewards;
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

    public Rewards getRewards() {
        return rewards;
    }

    public List<Direction> getDirectionAtHorizontalIndex(Integer index) {
        return ladder.getDirectionAtHorizontalIndex(index);
    }
}
