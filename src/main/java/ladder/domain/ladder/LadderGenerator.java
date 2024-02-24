package ladder.domain.ladder;

import ladder.domain.generator.BooleanGenerator;
import ladder.domain.player.Players;

public class LadderGenerator {
    private final BooleanGenerator booleanGenerator;

    public LadderGenerator(final BooleanGenerator booleanGenerator) {
        this.booleanGenerator = booleanGenerator;
    }

    public Ladder generate(final Players players, final Height height) {
        final int playerCount = players.count();
        final int ladderHeight = height.getValue();

        return new Ladder(playerCount, ladderHeight, booleanGenerator);
    }
}
