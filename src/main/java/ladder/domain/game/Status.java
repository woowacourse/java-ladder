package ladder.domain.game;

public enum Status {
    EXECUTABLE,
    NON_EXECUTABLE;

    public boolean isExecutable() {
        return this == EXECUTABLE;
    }
}
