package ladder.domain;

public class Index {

    private final int value;

    public Index(int value) {
        this.value = value;
    }

    public Index increase() {
        return new Index(value + 1);
    }

    public Index decrease() {
        return new Index(value - 1);
    }

    public int getValue() {
        return value;
    }
}
