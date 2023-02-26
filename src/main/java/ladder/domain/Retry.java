package ladder.domain;

public class Retry {

    private static final int LIMIT = 0;

    private int value;

    public Retry(final int value) {
        this.value = value;
    }

    public void decrease() {
        --value;
    }

    public void checkCount() {
        if (value <= LIMIT) {
            throw new IllegalStateException("재입력 횟수를 초과하였습니다.");
        }
    }
}
