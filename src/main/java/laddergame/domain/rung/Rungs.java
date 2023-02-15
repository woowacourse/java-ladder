package laddergame.domain.rung;

import laddergame.util.NumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class Rungs {

    private final List<Rung> rungs;

    private final NumberGenerator rungNumberGenerator;

    public Rungs(int rungCount, NumberGenerator rungNumberGenerator) {
        this.rungNumberGenerator = rungNumberGenerator;
        rungs = new ArrayList<>(rungCount);
        makeRungs(rungCount);
    }

    private void makeRungs(final int rungCount) {
        for (int i = 0; i < rungCount; i++) {
            if (i == 0) {
                makeRung(rungNumberGenerator.generate());
                continue;
            }
            if (rungs.get(i-1).isExistence()) {
                makeRung(Rung.INSUFFICIENT);
                continue;
            }
            makeRung(rungNumberGenerator.generate());
        }
    }

    private void makeRung(final int material) {
        Rung rung = new Rung(material);
        rungs.add(rung);
    }

    public List<Rung> getRungs() {
        return rungs;
    }
}
