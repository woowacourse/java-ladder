package ladder.domain.ladder;

public class LadderWidth {
    private int ladderWidth;

    public LadderWidth(int ladderWidth) {
        if (ladderWidth < 1) {
            throw new IllegalArgumentException("플레이어 수는 2이상 입니다.");
        }
        this.ladderWidth = ladderWidth;
    }

    public int getLadderWidth() {
        return ladderWidth;
    }
}
