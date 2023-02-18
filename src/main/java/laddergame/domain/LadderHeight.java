package laddergame.domain;

public class LadderHeight {

    private final int height;

    public LadderHeight(int ladderHeight) {
        this.height = ladderHeight;
    }

    public boolean isMaxHeight(int ladderHeight) {
        return height == ladderHeight;
    }
}
