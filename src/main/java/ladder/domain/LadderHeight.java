package ladder.domain;

public class LadderHeight {
    private static final int MIN_HEIGHT = 1;

    private int height;

    public LadderHeight(int height) {
        if (height < MIN_HEIGHT) {
            System.err.println("높이는 자연수만 가능합니다.");
            throw new IllegalArgumentException();
        }

        this.height = height;
    }

    public boolean isSmallerThanHeight(int num) {
        return num < height;
    }
}
