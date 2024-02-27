package laddergame.model;

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

    public static LineState decideLineState(LineState beforeState) {
        if (START.equals(beforeState)) {
            return END;
        }
        return NONE;
    }

    public static LineState decideLineState(LineState beforeState, boolean decision) {
        if (START.equals(beforeState)) {
            return END;
        }
        return decideLineState(decision);
    }
}
