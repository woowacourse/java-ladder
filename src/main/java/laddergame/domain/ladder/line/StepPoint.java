package laddergame.domain.ladder.line;

public enum StepPoint {

    EXIST(),
    NONE();

    public static StepPoint convert(boolean existing) {
        if (existing) {
            return EXIST;
        }
        return NONE;
    }

    public boolean isContinuous(StepPoint other) {
        return (this == EXIST) && (other == EXIST);
    }
}
