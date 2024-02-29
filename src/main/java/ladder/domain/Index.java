package ladder.domain;

public class Index {

    private static final int MAX_LENGTH = 5;

    private final int value;
    private final String data;

    public Index(int value, String data) {
        validateData(data);
        this.value = value;
        this.data = data;
    }

    private void validateData(String data) {
        validateNotEmpty(data);
        validateMaxLength(data);
    }

    private void validateNotEmpty(String data) {
        if (data.isEmpty()) {
            throw new IllegalArgumentException("이름이 1글자 미만입니다.");
        }
    }

    private void validateMaxLength(String data) {
        if (data.length() > MAX_LENGTH) {
            throw new IllegalArgumentException("이름이 5글자 초과입니다.");
        }
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
