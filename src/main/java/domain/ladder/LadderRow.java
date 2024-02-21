package domain.ladder;

import domain.BooleanGenerator;
import java.util.ArrayList;
import java.util.List;

class LadderRow {
    private final List<LadderRung> rungs;

    private LadderRow(final List<LadderRung> rungs) {
        this.rungs = rungs;
    }

    static LadderRow create(int playerSize, BooleanGenerator booleanGenerator) {
        final List<LadderRung> rungs = new ArrayList<>();
        boolean lastConnected = false;
        for (int i = 0; i < playerSize; i++) {
            LadderRung ladderRung = createRung(booleanGenerator, lastConnected);
            rungs.add(ladderRung);
            lastConnected = ladderRung.isConnected();
        }
        return new LadderRow(rungs);
    }

    private static LadderRung createRung(final BooleanGenerator booleanGenerator, final boolean lastConnected) {
        if (lastConnected) {
            return LadderRung.create(() -> false);
        }
        return LadderRung.create(booleanGenerator);
    }

    List<LadderRung> getRungs() {
        return this.rungs;
    }
}
