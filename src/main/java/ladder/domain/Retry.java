package ladder.domain;

public class Retry {

    private static final int LIMIT = 0;

    private int value;

    public Retry(final int value) {
        this.value = value;
    }

    public void decrease() {
        value--;
    }

    public boolean isPossible() {
        return value > LIMIT;
    }
}
