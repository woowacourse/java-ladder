package ladder.model;

public class Bar {
    private final int leftPosition;
    private final int rightPosition;

    public Bar(int leftPosition) {
        this.leftPosition = leftPosition;
        this.rightPosition = leftPosition + 1;
    }

    public int getLeftPosition() {
        return leftPosition;
    }
}
