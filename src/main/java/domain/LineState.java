package domain;

public enum LineState {
    MOVABLE_STATE(true),
    UNMOVABLE_STATE(false);

    private final boolean state;

    LineState(boolean state) {
        this.state = state;
    }

    public boolean getState() {
        return state;
    }

}
