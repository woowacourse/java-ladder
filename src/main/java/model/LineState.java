package model;

public enum LineState {
    START,
    END,
    NONE;

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
}
