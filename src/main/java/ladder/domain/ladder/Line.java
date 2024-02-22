package ladder.domain.ladder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import ladder.domain.ladder.generator.BooleanGenerator;

public class Line {
    private final BooleanGenerator booleanGenerator;
    private final List<Rung> rungs;

    public Line(final int playerCount, final BooleanGenerator booleanGenerator) {
        this.booleanGenerator = booleanGenerator;
        this.rungs = generateRungs(playerCount);
    }

    public List<Rung> generateRungs(final int playerCount) {
        final List<Rung> rungs = new ArrayList<>();

        for (int i = 0; i < playerCount - 1; i++) {
            final Rung rung = generateRung(rungs, i);
            rungs.add(rung);
        }

        return rungs;
    }

    private Rung generateRung(List<Rung> rungs, int index) {
        boolean previousRungExist = index > 0 && rungs.get(index - 1).isExist();
        boolean canMakeRung = booleanGenerator.generate();

        return Rung.of(!previousRungExist && canMakeRung);
    }

    public List<Rung> getRungs() {
        return Collections.unmodifiableList(rungs);
    }
}
