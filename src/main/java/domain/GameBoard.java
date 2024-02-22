package domain;

import domain.ladder.Ladder;
import domain.ladder.common.Direction;
import domain.player.Player;

import java.util.List;

public class GameBoard {
    private final List<Player> players;
    private final Ladder ladder;
    public GameBoard(List<Player> players, Ladder ladder){
        this.players = players;
        this.ladder = ladder;
    }

    public List<Player> getPlayers() {
        return players;
    }
    public int getLadderHeight(){
        return ladder.getHeight();
    }

    public Ladder getLadder() {
        return ladder;
    }
    public List<Direction> getDirectionAtHorizontalIndex(Integer index){
        return ladder.getDirectionAtHorizontalIndex(index);
    }
}
