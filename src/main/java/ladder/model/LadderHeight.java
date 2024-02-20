package ladder.model;

public class LadderHeight {
    private final int height;

    public LadderHeight(int height) {
        validate(height);
        this.height = height;
    }

    private void validate(int height) {
        if (!isNaturalNumber(height)) {
            throw new IllegalArgumentException("사다리 높이는 자연수여야 합니다.");
        }
    }

    private boolean isNaturalNumber(int height) {
        return height > 0;
    }
}
