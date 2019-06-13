package ladder.model;

import java.util.ArrayList;
import java.util.List;

public class Row {
    private static final int MOVE = 1;
    private static final int PREV = 1;
    private static final int BACK = -1;
    private static final int DIRECT = 0;
    private static final double HALF = 0.5;
    private List<Boolean> lines;

    Row(int countOfMembers) {
        lines = new ArrayList<>();
        lines.add(getRandom(false));

        for (int i = 1; i < countOfMembers - 1; i++) {
            lines.add(getRandom(lines.get(i - PREV)));
        }
    }

    private boolean getRandom(boolean prevStatus) {
        boolean coinFlip = Math.random() < HALF;
        return !prevStatus && coinFlip;
    }

    int judgeMove(int position) {
        if (position < lines.size() && lines.get(position)) {
            return MOVE;
        }
        if (position > 0 && lines.get(position - PREV)) {
            return BACK;
        }
        return DIRECT;
    }

    public List<Boolean> getLines() {
        return lines;
    }
}
