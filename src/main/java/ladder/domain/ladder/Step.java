package ladder.domain.ladder;

public enum Step {
    EXIST(true),
    NOT_EXIST(false);

    private final boolean status;

    Step(boolean status) {
        this.status = status;
    }

    public static Step from(boolean status) {
        if(status) {
            return EXIST;
        }
        return NOT_EXIST;
    }

    public static boolean isExist(Step step) {
        return step.status;
    }

    public boolean getStatus() {
        return status;
    }
}
