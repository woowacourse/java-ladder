package ladder.domain;

public class Ladder {
    public Ladder(int height) {
        validate(height);
    }

    private void validate(int height) {
        if (height <= 0) {
            throw new IllegalArgumentException("높이가 자연수가 아닙니다.");
        }
    }
}
