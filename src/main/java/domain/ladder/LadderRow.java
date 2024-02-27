package domain.ladder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LadderRow {
    private final List<LadderRung> rungs;

    private LadderRow(final List<LadderRung> rungs) {
        this.rungs = rungs;
    }

    static LadderRow create(int width, LadderRungGenerator ladderRungGenerator) {
        final List<LadderRung> rungs = new ArrayList<>();
        LadderRung previousRung = LadderRung.DISCONNECTED;
        for (int i = 0; i < width; i++) {
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

    void crossRungs(List<String> names) {
        for (int nowIndex = 0; nowIndex < names.size(); nowIndex += 2) {
            int nextIndex = crossRung(nowIndex);
            Collections.swap(names, nowIndex, nextIndex);
        }
    }

    private int crossRung(int nowIndex) {
        if (existsConnectedLeftRung(nowIndex)) {
            return nowIndex - 1;
        }
        if (existsConnectedRightRung(nowIndex)) {
            return nowIndex + 1;
        }
        return nowIndex;
    }

    private boolean existsConnectedLeftRung(int nowIndex) {
        return nowIndex > 0 && rungs.get(nowIndex - 1).isConnected();
    }

    private boolean existsConnectedRightRung(int nowIndex) {
        return nowIndex < rungs.size() && rungs.get(nowIndex).isConnected();
    }

    public List<LadderRung> getRungs() {
        return Collections.unmodifiableList(this.rungs);
    }
}
