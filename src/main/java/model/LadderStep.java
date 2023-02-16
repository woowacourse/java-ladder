package model;

public enum LadderStep {
    FIRST_STEP(String.format("%5s","    |")),
    EMPTY_STEP(String.format("%6s","     |")),
    EXIST_STEP(String.format("%6s","-----|"));

    private static final int LIMIT_NAME_LENGTH = 5;

    private final String step;

    LadderStep(String step) {
        this.step = step;
    }

    public String getStep() {
        return step;
    }
}
