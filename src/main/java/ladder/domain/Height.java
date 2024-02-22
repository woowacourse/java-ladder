package ladder.domain;

public class Height {

    private final int value;

    public Height(int value) {
        this.value = value;
    }

    public boolean isSame(int value) {
        return this.value == value;
    }
}
