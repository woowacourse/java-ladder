package ladder.domain;

public enum StepStatus {
    EXIST, NONE;

    public static StepStatus getStepStatus(final boolean current) {
        if (current) {
            return EXIST;
        }
        return NONE;
    }

    public boolean isExist() {
        return this == EXIST;
    }
}
