package ladder.domain.ladder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import ladder.domain.ladder.generator.RungGenerator;

public class Line {
    private final RungGenerator rungGenerator;
    private final List<Rung> rungs;

    public Line(int playerCount, RungGenerator rungGenerator) {
        this.rungGenerator = rungGenerator;
        this.rungs = generateRungs(playerCount);
    }

    public List<Rung> generateRungs(int playerCount) {
        List<Rung> rungs = new ArrayList<>();

        for (int i = 0; i < playerCount - 1; i++) {
            Rung rung = generateRung(rungs, i);
            rungs.add(rung);
        }

        return rungs;
    }

    private Rung generateRung(List<Rung> rungs, int index) {
        boolean previousRungExist = index > 0 && rungs.get(index - 1).isExist();
        Rung currentRung = rungGenerator.generate();

        if (previousRungExist && currentRung.isExist()) {
            return Rung.of(false);
        }

        return currentRung;
    }

    public List<Rung> getRungs() {
        return Collections.unmodifiableList(rungs);
    }
}
