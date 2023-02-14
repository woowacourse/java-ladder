package domain;

public class LadderHeight {

    private static final int MIN_LADDER_HEIGHT = 1;

    private final int ladderHeight;

    public LadderHeight(int ladderHeight) {
        if (ladderHeight < MIN_LADDER_HEIGHT) {
            throw new IllegalArgumentException(String.format("[ERROR] 다리 길이는 양수여야합니다. 입력값 : %s", ladderHeight));
        }
        this.ladderHeight = ladderHeight;
    }
}
