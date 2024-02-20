package ladder.domain.ladder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import ladder.domain.generator.BooleanGenerator;

public class Line {
    private final BooleanGenerator booleanGenerator;
    private final List<Rung> rungs;

    public Line(int playerCount, BooleanGenerator booleanGenerator) {
        this.booleanGenerator = booleanGenerator;
        this.rungs = generateRungs(playerCount);
    }

    public List<Rung> generateRungs(int playerCount) {
        List<Rung> rungs = new ArrayList<>();

        boolean previousRungExist = false;
        for (int currentPlayerCount = 0; currentPlayerCount < playerCount - 1; currentPlayerCount++) {
            boolean currentRungExist = booleanGenerator.generate();

            rungs.add(classifyRungStatus(previousRungExist, currentRungExist));
            previousRungExist = !previousRungExist && currentRungExist;
        }

        return rungs;
    }

    private Rung classifyRungStatus(boolean previousRungExist, boolean currentRungExist) {
        if (!previousRungExist && currentRungExist) {
            return Rung.EXIST;
        }
        return Rung.EMPTY;
    }

    public List<Rung> getRungs() {
        return Collections.unmodifiableList(rungs);
    }
}
