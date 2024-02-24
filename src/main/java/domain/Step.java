package domain;

public enum Step {
    EXIST, EMPTY;

    public static Step from(boolean hasStep) {
        if (hasStep) {
            return EXIST;
        }
        return EMPTY;
    }

    public boolean isExist() {
        return this.equals(EXIST);
    }
}
