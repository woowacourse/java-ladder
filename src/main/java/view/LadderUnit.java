package view;

import ladder.Direction;

public enum LadderUnit {
    STRAIGHT("    | "),
    LEFT("----| "),
    RIGHT("    |-");

    private final String display;

    LadderUnit(String display) {
        this.display = display;
    }

    public static LadderUnit fromDirection(Direction direction) {
        if (direction == Direction.STRAIGHT) {
            return STRAIGHT;
        }
        if (direction == Direction.LEFT) {
            return LEFT;
        }
        return RIGHT;
    }

    public String getDisplay() {
        return display;
    }
}
