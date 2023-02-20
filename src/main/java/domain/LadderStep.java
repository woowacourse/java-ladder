package domain;

public enum LadderStep {
    EXISTS, NONE;

    public static LadderStep from(boolean isExist) {
        if (isExist) {
            return EXISTS;
        }
        return NONE;
    }

    public boolean exists() {
        return this == EXISTS;
    }
}
