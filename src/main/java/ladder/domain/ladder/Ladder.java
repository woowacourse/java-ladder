package ladder.domain.ladder;

import ladder.domain.generator.RandomRungGenerator;
import ladder.domain.generator.RungGenerator;

public class Ladder {
    private final int playerCount;
    private final Height height;
    private final RungGenerator rungGenerator;

    public Ladder(int playerCount, int height, RungGenerator rungGenerator) {
        this.playerCount = playerCount;
        this.height = new Height(height);
        this.rungGenerator = rungGenerator;
    }

    public int getHeight() {
        return height.getHeight();
    }
}
