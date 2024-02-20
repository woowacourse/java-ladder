package domain;

public class LadderHeight {
    public LadderHeight(int height) {
        validate(height);
    }

    private void validate(int height) {
        if (height < 1) {
            throw new IllegalArgumentException();
        }
    }
}
