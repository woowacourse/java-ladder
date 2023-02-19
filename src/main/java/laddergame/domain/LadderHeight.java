package laddergame.domain;

public class LadderHeight {

    private final int value;

    public LadderHeight(int ladderHeight) {
        this.value = ladderHeight;
    }

    public boolean isEqualTo(int ladderSize) {
        return value == ladderSize;
    }
}
