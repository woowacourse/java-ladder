package model.ladder;

public enum StepStatus {
    CONNECTED,
    DISCONNECTED,
    EMPTY;

    public static StepStatus from(final boolean status) {
        if (status) {
            return CONNECTED;
        }
        return DISCONNECTED;
    }

    public boolean isMatched(StepStatus stepStatus) {
        return equals(stepStatus);
    }
}
