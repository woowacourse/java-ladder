package ladder.domain.ladder;

import java.util.Collections;
import java.util.List;

public class Line {
    private final List<Rung> rungs;

    public Line(final List<Boolean> rungsExist) {
        this.rungs = makeUnconnectedLine(rungsExist);
    }

    private List<Rung> makeUnconnectedLine(final List<Boolean> rungsExist) {
        for (int index = 1; index < rungsExist.size(); index++) {
            removeContinuousRung(index, rungsExist);
        }

        return mapRung(rungsExist);
    }

    private void removeContinuousRung(final int index, final List<Boolean> rungsExist) {
        if (isContinuousRung(index, rungsExist)) {
            rungsExist.set(index, false);
        }
    }

    private boolean isContinuousRung(final int index, final List<Boolean> rungsExist) {
        return rungsExist.get(index) && rungsExist.get(index - 1);
    }

    private List<Rung> mapRung(final List<Boolean> rungsExist) {
        return rungsExist.stream()
                .map(Rung::from)
                .toList();
    }

    public List<Rung> getRungs() {
        return Collections.unmodifiableList(rungs);
    }
}
