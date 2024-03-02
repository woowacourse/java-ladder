package laddergame.domain;

import laddergame.util.RungGenerator;

import java.util.ArrayList;
import java.util.List;

public class LineBuilder {
    private final RungGenerator rungGenerator;
    private final int width;

    public LineBuilder(final RungGenerator rungGenerator, final int width) {
        this.rungGenerator = rungGenerator;
        this.width = width;
    }

    public Line build() {
        List<Rung> rungStatuses = new ArrayList<>();

        rungStatuses.add(rungGenerator.generate());
        for (int i = 0; i < width - 1; i++) {
            Rung beforeValue = rungStatuses.get(rungStatuses.size() -1);
            rungStatuses.add(decideNextValue(beforeValue));
        }
        return new Line(rungStatuses);
    }

    private Rung decideNextValue(Rung beforeValue) {
        if (beforeValue.equals(Rung.BRIDGE)) {
            return Rung.EMPTY;
        }
        return rungGenerator.generate();
    }
}
