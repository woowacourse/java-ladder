package ladder.domain.ladder;

import ladder.domain.generator.BooleanGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Line {
    private final BooleanGenerator booleanGenerator;
    private final List<Rung> rungs;

    public Line(final int playerCount, final BooleanGenerator booleanGenerator) {
        this.booleanGenerator = booleanGenerator;
        this.rungs = generateRungs(playerCount);
    }

    public List<Rung> generateRungs(final int playerCount) {
        final List<Rung> rungs = new ArrayList<>();

        for (int currentPlayerCount = 0; currentPlayerCount < playerCount - 1; currentPlayerCount++) {
            final boolean previousRungExist = currentPlayerCount > 0 && rungs.get(currentPlayerCount - 1).isExist();
            final boolean currentRungExist = booleanGenerator.generate();

            final Rung rung = Rung.of(!previousRungExist && currentRungExist);
            rungs.add(rung);
        }

        return rungs;
    }

    public List<Rung> getRungs() {
        return Collections.unmodifiableList(rungs);
    }
}
