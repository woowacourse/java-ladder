package laddergame.domain.ladder;

import laddergame.util.BooleanGenerator;

import java.util.ArrayList;
import java.util.List;

public class Line {

    public static final boolean DOES_NOT_EXIST = false;
    private static final int MINIMUM_INDEX = 0;

    private final List<Rung> rungs;
    private final BooleanGenerator rungBooleanGenerator;

    private Line(final int rungCount, final BooleanGenerator rungBooleanGenerator) {
        this.rungBooleanGenerator = rungBooleanGenerator;
        rungs = makeRungs(rungCount);
    }

    public static Line create(final int rungCount, final BooleanGenerator rungBooleanGenerator) {
        return new Line(rungCount, rungBooleanGenerator);
    }

    public boolean hasRung(final int index) {
        if (index < MINIMUM_INDEX || index >= rungs.size()) {
            return DOES_NOT_EXIST;
        }
        Rung rung = rungs.get(index);
        return rung.exists();
    }

    public int size() {
        return rungs.size();
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
