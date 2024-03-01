package ladder.domain.ladder;

public enum Stick {

    EXISTENCE, NON_EXISTENCE;

    public boolean isExist() {
        return this == EXISTENCE;
    }
}
