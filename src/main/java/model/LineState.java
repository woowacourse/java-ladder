package model;

public enum LineState {
    START("start"),
    END("end"),
    NONE("none");

    private final String state;

    LineState(String state) {
        this.state = state;
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
}
