package ladder.domain;

public enum Step {
    BLANK(false), CONNECTED(true);

    private final boolean value;

    Step(boolean value) {
        this.value = value;
    }

}
