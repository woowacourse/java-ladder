package ladder.domain;

public class LadderGame {

    private static final int RIGHT = 1;
    private static final int LEFT = 2;
    private static final int STRAIGHT = 0;
    private static final int MOVEMENT = 1;

    private final Ladder ladder;

    public LadderGame(Ladder ladder) {
        this.ladder = ladder;
    }

    public LadderGameResult start() {
        int[] result = new int[ladder.getNames().length];
        for (int i = 0; i < ladder.getNames().length; i++) {
            result[i] = getUserResult(i);
        }
        return new LadderGameResult(result);
    }

    private int getUserResult(int index) {
        for (Line line : ladder.getLines()) {
            int[] points = line.getPoints();
            index += judgeLeftOrRightOrStraight(points[index]);
        }
        return index;
    }

    private int judgeLeftOrRightOrStraight(int point) {
        if (point == RIGHT) {
            return MOVEMENT;
        }
        if (point == LEFT) {
            return -MOVEMENT;
        }
        return STRAIGHT;
    }
}
