package laddergame.model.laddergame;

public enum LineState {
    START,
    END,
    NONE;

    public static LineState decideLineState(LineConnectionDecision decision) {
        if (decision.isConnectionTried()) {
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

    public static LineState decideLineState(LineState beforeState, LineConnectionDecision decision) {
        if (START.equals(beforeState)) {
            return END;
        }
        return decideLineState(decision);
    }

    public boolean isStart() {
        return START.equals(this);
    }

    public boolean isEnd() {
        return END.equals(this);
    }
}
