package ladder.dto;

public class PointsTupleDto {
    private final boolean right;

    public PointsTupleDto(boolean right) {
        this.right = right;
    }

    public boolean getRight() {
        return right;
    }
}