package domain;

public enum LineState {
    MOVABLE_STATE(1, true),
    UNMOVABLE_STATE(0, false);

    private final int value;
    private final boolean state;

    LineState(int value, boolean state) {
        this.value = value;
        this.state = state;
    }

    public boolean getState() {
        return state;
    }

    public static LineState of(int value) {
        for (LineState lineState : LineState.values()) {
            if (lineState.value == value) {
                return lineState;
            }
        }
        throw new IllegalArgumentException();
    }
}
