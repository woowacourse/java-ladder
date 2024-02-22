package model;

public enum LineState {
    START("start"),
    END("end"),
    NONE("none");

    private final String state;

    LineState(String state) {
        this.state = state;
    }

    public static LineState decideLineState(boolean decision) {
        if (decision) {
            return START;
        }
        return NONE;
    }

    public static LineState decideLineStateWithBeforeState(LineState beforeState, boolean decision) {
        if (START.equals(beforeState)) {
            return END;
        }
        return decideLineState(decision);
    }

    public String getState() {
        return state;
    }
}
