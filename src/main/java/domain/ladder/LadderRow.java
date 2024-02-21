package domain.ladder;

import domain.BooleanGenerator;
import domain.Connection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class LadderRow {
    private final List<LadderRung> rungs;

    private LadderRow(final List<LadderRung> rungs) {
        this.rungs = rungs;
    }

    static LadderRow create(int size, BooleanGenerator booleanGenerator) {
        final List<LadderRung> rungs = new ArrayList<>();
        boolean lastConnected = Connection.IS_NOT_CONNECTED.getValue();
        for (int i = 0; i < size; i++) {
            LadderRung ladderRung = createRung(booleanGenerator, lastConnected);
            rungs.add(ladderRung);
            lastConnected = ladderRung.isConnected();
        }
        return new LadderRow(rungs);
    }

    private static LadderRung createRung(final BooleanGenerator booleanGenerator, final boolean lastConnected) {
        if (lastConnected) {
            return LadderRung.create(Connection.IS_NOT_CONNECTED::getValue);
        }
        return LadderRung.create(booleanGenerator);
    }

    List<LadderRung> getRungs() {
        return Collections.unmodifiableList(this.rungs);
    }
}
