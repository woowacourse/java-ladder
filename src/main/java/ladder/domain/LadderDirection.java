package ladder.domain;

import java.util.Random;

public enum LadderDirection {
    LEFT, RIGHT, NONE;

    public LadderDirection next() {
        if (this == RIGHT) {
            return LEFT;
        }
        return pickRightOrNone();
    }

    private LadderDirection pickRightOrNone() {
        if (new Random().nextBoolean()) {
            return RIGHT;
        }
        return NONE;
    }
}
