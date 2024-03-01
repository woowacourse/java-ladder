package domain.ladder;

public enum Step {
    EXIST, EMPTY;

    public static Step from(final boolean hasStep) {
        if (hasStep) {
            return EXIST;
        }
        return EMPTY;
    }

    public boolean isExist() {
        return this.equals(EXIST);
    }
}
