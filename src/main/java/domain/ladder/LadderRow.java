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
        for (int nowVerticalLine = 0; nowVerticalLine < names.size(); nowVerticalLine += 2) {
            int nextVerticalLine = moveNextVerticalLine(nowVerticalLine);
            Collections.swap(names, nowVerticalLine, nextVerticalLine);
        }
    }

    private int moveNextVerticalLine(int nowVerticalLine) {
        int nextVerticalLine = crossLeftRung(nowVerticalLine);
        if (nextVerticalLine != nowVerticalLine) {
            return nextVerticalLine;
        }
        return crossRightRung(nowVerticalLine);
    }

    private int crossLeftRung(int now) {
        if (now <= 0) {
            return now;
        }
        LadderRung leftRung = rungs.get(now - 1);
        if (leftRung.isConnected()) {
            return now - 1;
        }
        return now;
    }

    private int crossRightRung(int now) {
        if (now >= rungs.size()) {
            return now;
        }
        LadderRung rightRung = rungs.get(now);
        if (rightRung.isConnected()) {
            return now + 1;
        }
        return now;
    }

    public List<LadderRung> getRungs() {
        return Collections.unmodifiableList(this.rungs);
    }
}
