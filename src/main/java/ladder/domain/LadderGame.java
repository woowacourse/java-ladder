package ladder.domain;

import java.util.HashMap;
import java.util.Map;

public class LadderGame {

    private static final int RIGHT = 1;
    private static final int LEFT = 2;
    private static final int STRAIGHT = 0;
    private static final int MOVEMENT = 1;

    private final Ladder ladder;
    private final String[] names;
    private final String[] prizes;

    public LadderGame(Ladder ladder, String[] names, String[] prizes) {
        this.ladder = ladder;
        this.names = names;
        this.prizes = prizes;
    }

    public LadderGameResult start() {
        int[] result = new int[names.length];
        for (int i = 0; i < names.length; i++) {
            result[getUserResult(i)] = i;
        }
        Map<String, String> nameToPrize = new HashMap<>();
        for (int i = 0; i < result.length; i++) {
            nameToPrize.put(names[result[i]], prizes[i]);
        }
        return new LadderGameResult(nameToPrize);
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

    public String[] getNames() {
        return this.names;
    }

    public String[] getPrizes(){
        return this.prizes;
    }

    public Ladder getLadder(){
        return this.ladder;
    }
}
