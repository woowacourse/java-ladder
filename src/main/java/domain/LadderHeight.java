package domain;

public class LadderHeight {

    private static final int MIN_LADDER_HEIGHT = 1;

    private final int ladderHeight;

    public LadderHeight(int ladderHeight) {
        validate(ladderHeight);
        this.ladderHeight = ladderHeight;
    }

    private void validate(int ladderHeight) {
        if (ladderHeight < MIN_LADDER_HEIGHT) {
            throw new IllegalArgumentException(String.format("다리 길이는 양수여야합니다. 입력값 : %s", ladderHeight));
        }
    }

    public int getLadderHeight() {
        return this.ladderHeight;
    }
}
