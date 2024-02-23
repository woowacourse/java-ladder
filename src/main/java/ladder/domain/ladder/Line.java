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
            Rung rung = generateRung(rungs);
            rungs.add(rung);
        }

        return rungs;
    }

    private Rung generateRung(List<Rung> rungs) {
        Rung currentRung = rungGenerator.generate();

        if (rungs.isEmpty()) {
            return currentRung;
        }

        boolean previousRungExist = rungs.get(rungs.size() - 1).isExist();

        if (previousRungExist || currentRung.isEmpty()) {
            return Rung.EMPTY;
        }

        return Rung.EXIST;
    }

    public int findConnectedIndex(int index) {
        if (canMoveLeft(index)) {
            return index - 1;
        }

        if (canMoveRight(index)) {
            return index + 1;
        }

        return index;
    }

    private boolean canMoveLeft(int index) {
        return index > 0 && rungs.get(index - 1).isExist();
    }

    private boolean canMoveRight(int index) {
        return index < rungs.size() && rungs.get(index).isExist();
    }

    public List<Rung> getRungs() {
        return Collections.unmodifiableList(rungs);
    }
}
