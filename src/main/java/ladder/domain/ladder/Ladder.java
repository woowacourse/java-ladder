package ladder.domain.ladder;

public class Ladder {
    private final int playerCount;
    private final Height height;

    public Ladder(int playerCount, int height) {
        this.playerCount = playerCount;
        this.height = new Height(height);
    }

    public int getHeight() {
        return height.getHeight();
    }
}
