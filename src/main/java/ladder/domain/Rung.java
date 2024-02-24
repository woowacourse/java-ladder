package ladder.domain;

public enum Rung {
    EXIST(true),
    NOT_EXIST(false);

    private final boolean buildStatus;

    Rung(boolean buildStatus) {
        this.buildStatus = buildStatus;
    }

    public boolean isBuildStatus() {
        return buildStatus;
    }
}
