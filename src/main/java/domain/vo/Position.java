package domain.vo;

public class Position {
    private final int value;

    public Position(final int value) {
        this.value = value;
        validate();
    }

    public int get() {
        return value;
    }

    private void validate() {
        if (value < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }
}
