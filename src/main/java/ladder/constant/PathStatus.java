package ladder.constant;

public enum PathStatus {
    EXIST, NONE;

    public static PathStatus getStepStatus(final boolean current) {
        if (current) {
            return EXIST;
        }
        return NONE;
    }

    public boolean isExist() {
        return this == EXIST;
    }
}
