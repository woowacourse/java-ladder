package laddergame.domain.ladder;

import laddergame.domain.rung.Rung;
import laddergame.util.BooleanGenerator;

import java.util.ArrayList;
import java.util.List;

public class Line {

    private final List<Rung> rungs;
    private final BooleanGenerator rungBooleanGenerator;

    private Line(final int rungCount, final BooleanGenerator rungBooleanGenerator) {
        this.rungBooleanGenerator = rungBooleanGenerator;
        rungs = makeRungs(rungCount);
    }

    public static Line create(final int rungCount, final BooleanGenerator rungBooleanGenerator) {
        return new Line(rungCount, rungBooleanGenerator);
    }

    private List<Rung> makeRungs(final int rungCount) {
        List<Rung> rungs = new ArrayList<>();
        Rung firstRung = Rung.create(rungBooleanGenerator.generate());
        rungs.add(firstRung);

        for (int order = 1; order < rungCount; order++) {
            Rung previousRung = rungs.get(order - 1);
            Rung newRung = createRung(previousRung);
            rungs.add(newRung);
        }
        return rungs;
    }

    private Rung createRung(final Rung previousRung) {
        if (previousRung.exists()) {
            return Rung.create(false);
        }
        return Rung.create(rungBooleanGenerator.generate());
    }

    public List<Rung> getRungs() {
        return rungs;
    }
}
