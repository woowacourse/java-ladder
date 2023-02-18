package laddergame.domain.rung;

import laddergame.util.NumberGenerator;

import java.util.ArrayList;
import java.util.List;

import static laddergame.domain.rung.Rung.INSUFFICIENT;

public class Rungs {

    private final List<Rung> rungs;
    private final NumberGenerator rungNumberGenerator;

    private Rungs(final int rungCount, final NumberGenerator rungNumberGenerator) {
        this.rungNumberGenerator = rungNumberGenerator;
        rungs = makeRungs(rungCount);
    }

    public static Rungs create(final int rungCount, final NumberGenerator rungNumberGenerator) {
        return new Rungs(rungCount, rungNumberGenerator);
    }

    private List<Rung> makeRungs(final int rungCount) {
        List<Rung> rungs = new ArrayList<>();
        Rung firstRung = Rung.create(rungNumberGenerator.generate());
        rungs.add(firstRung);

        for (int order = 1; order < rungCount; order++) {
            Rung previousRung = rungs.get(order - 1);
            Rung newRung = createRung(previousRung);
            rungs.add(newRung);
        }
        return rungs;
    }

    private Rung createRung(final Rung previousRung) {
        if (previousRung.isExistence()) {
            return Rung.create(INSUFFICIENT);
        }
        return Rung.create(rungNumberGenerator.generate());
    }

    public List<Rung> getRungs() {
        return List.copyOf(rungs);
    }
}
