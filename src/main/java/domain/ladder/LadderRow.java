package domain.ladder;

import domain.booleanGenerator.BooleanGenerator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LadderRow {
    private final List<LadderRung> rungs;

    public LadderRow(BooleanGenerator booleanGenerator, int size) {
        rungs = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            LadderRung ladderRung = findNextRung(booleanGenerator, getLastRung());
            rungs.add(ladderRung);
        }
    }

    private LadderRung findNextRung(final BooleanGenerator booleanGenerator, final LadderRung lastRung) {
        if (lastRung.isConnected()) {
            return LadderRung.findRung(LadderRung.NOT_CONNECTED.isConnected());
        }
        return LadderRung.findRung(booleanGenerator.generate());
    }

    private LadderRung getLastRung() {
        if (!rungs.isEmpty()) {
            return rungs.get(rungs.size() - 1);
        }
        return LadderRung.NOT_CONNECTED;
    }

    public List<LadderRung> getRungs() {
        return Collections.unmodifiableList(this.rungs);
    }
}
