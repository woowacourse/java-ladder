package ladder.domain;

public class Retry {

    private static final int LIMIT = 0;
    private static final int DEFAULT_VALUE = 5;

    private int value;

    public Retry() {
        this(DEFAULT_VALUE);
    }

    public Retry(final int value) {
        this.value = value;
    }

    public void decrease() {
        --value;
        if (value < LIMIT) {
            throw new IllegalStateException("재입력 횟수를 초과하였습니다.");
        }
    }

    public Retry renew() {
        return new Retry();
    }
}
