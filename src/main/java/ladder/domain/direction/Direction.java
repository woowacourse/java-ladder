package ladder.domain.direction;

import javax.swing.*;
import java.util.Arrays;

public enum Direction {
    RIGHT,
    NEUTRAL,
    LEFT;

    public static Direction getDirection(boolean isRight) {
        if (isRight) {
            return RIGHT;
        }
        return NEUTRAL;
    }
}
