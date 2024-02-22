package domain.ladder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LadderRow {
    private final List<LadderRung> rungs;

    private LadderRow(final List<LadderRung> rungs) {
        this.rungs = rungs;
    }

    static LadderRow create(int size, LadderRungGenerator ladderRungGenerator) {
        final List<LadderRung> rungs = new ArrayList<>();
        LadderRung previousRung = LadderRung.DISCONNECTED;
        for (int i = 0; i < size; i++) {
            LadderRung ladderRung = createRung(ladderRungGenerator, previousRung);
            rungs.add(ladderRung);
            previousRung = ladderRung;
        }
        return new LadderRow(rungs);
    }

    private static LadderRung createRung(final LadderRungGenerator ladderRungGenerator, final LadderRung previousRung) {
        if (previousRung.isConnected()) {
            return LadderRung.DISCONNECTED;
        }
        return ladderRungGenerator.generate();
    }

    public List<LadderRung> getRungs() {
        return Collections.unmodifiableList(this.rungs);
    }
}
