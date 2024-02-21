import java.util.List;

public class GameBoard {
    private final List<Player> players;
    private final Ladder ladder;
    public GameBoard(List<Player> players,Ladder ladder){
        this.players = players;
        this.ladder = ladder;
    }

    public Ladder getLadder() {
        return ladder;
    }
    public List<Direction> getDirectionAtHorizontalIndex(Integer index){
        return ladder.getDirectionAtHorizontalIndex(index);
    }
}
