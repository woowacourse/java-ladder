package model;

import java.util.Arrays;

public enum LineState {
    START(1),
    END(-1),
    NONE(0),
    NOTHING(0);

    private final int direction;

    LineState(int direction) {
        this.direction = direction;
    }

    public static LineState decideFirstLineState(boolean decision) {
        if (decision) {
            return START;
        }
        return NONE;
    }

    public static LineState decideMiddleLineState(LineState beforeState, boolean decision) {
        if (START.equals(beforeState)) {
            return END;
        }
        return decideFirstLineState(decision);
    }

    public static LineState decideLastLineState(LineState beforeState) {
        if (START.equals(beforeState)) {
            return END;
        }
        return NONE;
    }

    public static int findDirection(LineState target) {
        LineState result = Arrays.stream(LineState.values())
                .filter(l -> l.equals(target))
                .findAny()
                .orElse(NOTHING);
        return result.direction;
    }
}
