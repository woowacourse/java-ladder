package ladder.domain.ladder;

import ladder.domain.generator.BooleanGenerator;

public class Ladder {
    private final int playerCount;
    private final Height height;
    private final BooleanGenerator booleanGenerator;

    public Ladder(int playerCount, int height, BooleanGenerator booleanGenerator) {
        this.playerCount = playerCount;
        this.height = new Height(height);
        this.booleanGenerator = booleanGenerator;
    }

    public int getHeight() {
        return height.getHeight();
    }
}
