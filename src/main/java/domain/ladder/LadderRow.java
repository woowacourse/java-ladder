package domain.ladder;

import domain.BooleanGenerator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LadderRow {
    private final List<LadderRung> rungs;

    private LadderRow(final List<LadderRung> rungs) {
        this.rungs = rungs;
    }

    static LadderRow create(BooleanGenerator booleanGenerator, int size) {
        final List<LadderRung> rungs = new ArrayList<>();
        boolean lastConnected = LadderRung.NOT_CONNECTED.isConnected();
        for (int i = 0; i < size; i++) {
            LadderRung ladderRung = createRung(booleanGenerator, lastConnected);
            rungs.add(ladderRung);
            lastConnected = ladderRung.isConnected();
        }
        return new LadderRow(rungs);
    }

    private static LadderRung createRung(final BooleanGenerator booleanGenerator, final boolean lastConnected) {
        if (lastConnected) {
            return LadderRung.findRung(LadderRung.NOT_CONNECTED.isConnected());
        }
        return LadderRung.findRung(booleanGenerator.generate());
    }

    public List<LadderRung> getRungs() {
        return Collections.unmodifiableList(this.rungs);
    }
}
