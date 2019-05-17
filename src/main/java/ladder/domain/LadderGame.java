package ladder.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LadderGame {

    private static final int MOVEMENT = 1;

    private final Ladder ladder;
    private final List<Player> players;
    private final List<Prize> prizes;

    public LadderGame(Ladder ladder, List<Player> players, List<Prize> prizes) {
        this.ladder = ladder;
        this.players = players;
        this.prizes = prizes;
    }

    public LadderGameResult start() {
        int[] result = new int[players.size()];
        for (int i = 0; i < players.size(); i++) {
            result[getUserResult(i)] = i;
        }
        return new LadderGameResult(getNameToPrize(result));
    }

    private int getUserResult(int index) {
        for (Line line : ladder.getLines()) {
            Direction[] points = line.getPoints();
            index += judgeDirection(points[index]);
        }
        return index;
    }

    private Map<Player, Prize> getNameToPrize(int[] result) {
        Map<Player, Prize> nameToPrize = new HashMap<>();
        for (int i = 0; i < result.length; i++) {
            nameToPrize.put(players.get(result[i]), prizes.get(i));
        }

        return nameToPrize;
    }

    private int judgeDirection(Direction direction) {
        if (direction == Direction.RIGHT) {
            return MOVEMENT;
        }
        if (direction == Direction.LEFT) {
            return -MOVEMENT;
        }
        return Direction.STRAIGHT.getDirection();
    }

    public List<Player> getPlayers() {
        return players;
    }

    public List<Prize> getPrizes() {
        return this.prizes;
    }

    public Ladder getLadder() {
        return this.ladder;
    }
}
