package ladder.domain;

public class Index {

    private final int value;
    private final String data;

    public Index(int value, String data) {
        this.value = value;
        this.data = data;
    }

    public Index increase() {
        return new Index(value + 1, data);
    }

    public Index decrease() {
        return new Index(value - 1, data);
    }

    public int getValue() {
        return value;
    }

    public String getData() {
        return data;
    }
}
