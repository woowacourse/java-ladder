package ladder.domain.ladder;

import java.util.Collections;
import java.util.List;

public class Line {
    private final List<Rung> rungs;

    public Line(final List<Boolean> rungStatuses) {
        this.rungs = makeUnconnectedLine(rungStatuses);
    }

    private List<Rung> makeUnconnectedLine(final List<Boolean> rungExist) {
        for (int index = 1; index < rungExist.size(); index++) {
            removeContinuousRung(index, rungExist);
        }

        return mapRung(rungExist);
    }

    private void removeContinuousRung(final int index, final List<Boolean> rungExist) {
        if (isContinuousRung(index, rungExist)) {
            rungExist.set(index, false);
        }
    }

    private boolean isContinuousRung(final int index, final List<Boolean> rungExist) {
        return rungExist.get(index) && rungExist.get(index - 1);
    }

    private List<Rung> mapRung(final List<Boolean> rungExist) {
        return rungExist.stream()
                .map(Rung::of)
                .toList();
    }

    public List<Rung> getRungs() {
        return Collections.unmodifiableList(rungs);
    }
}
