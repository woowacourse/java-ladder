package ladder.model;

public record LadderSize(int height, int width) {
    public LadderSize {
        validate(height, width);
    }

    private void validate(int height, int width) {
        if (isNotNaturalNumber(height) || isNotNaturalNumber(width)) {
            throw new IllegalArgumentException("사다리 높이는 자연수여야 합니다.");
        }
    }

    private boolean isNotNaturalNumber(int value) {
        return value <= 0;
    }
}
