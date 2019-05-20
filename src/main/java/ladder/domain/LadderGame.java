package ladder.domain;

import java.util.List;

public class LadderGame {
    private static final int MOVEMENT = 1;

    private final Ladder ladder;
    private final Players players;
    private final Prizes prizes;

    public LadderGame(Ladder ladder, Players players, Prizes prizes) {
        this.ladder = ladder;
        this.players = players;
        this.prizes = prizes;
    }

    public LadderGameResult start() {
        int[] result = new int[players.getCount()];
        for (int i = 0; i < players.getCount(); i++) {
            result[getUserResult(i)] = i;
        }
        return new LadderGameResult(result, players, prizes);
    }

    private int getUserResult(int index) {
        for (Line line : ladder.getLines()) {
            List<Direction> points = line.getDirections();
            index += judgeLeftOrRightOrStraight(points.get(index));
        }
        return index;
    }

    private int judgeLeftOrRightOrStraight(Direction direction) {
        if (direction == Direction.RIGHT) {
            return MOVEMENT;
        }
        if (direction == Direction.LEFT) {
            return -MOVEMENT;
        }
        return Direction.STRAIGHT.getDirection();
    }

    public Players getPlayers() {
        return this.players;
    }

    public Prizes getPrizes() {
        return this.prizes;
    }

    public Ladder getLadder() {
        return this.ladder;
    }
}
