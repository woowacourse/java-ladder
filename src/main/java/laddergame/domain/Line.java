package laddergame.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Line {
    private List<Boolean> points;

    public Line(final int playerCount) {
        this.points = new ArrayList<>(Collections.nCopies(playerCount - 1, Boolean.FALSE));
    }

    public void buildBridge(List<Boolean> isBridgeBuilt) {
        validate(isBridgeBuilt);
        this.points = isBridgeBuilt;
    }

    private void validate(final List<Boolean> isBridgeBuilt) {
        boolean isTrue = false;
        for (Boolean previous : isBridgeBuilt) {
            if (previous && isTrue) {
                throw new IllegalStateException();
            }
            if (previous) {
                isTrue = true;
                continue;
            }
            isTrue = false;
        }
    }

    public boolean isBuilt(final int position) {
        return points.get(position);
    }

    public List<Boolean> getPoints() {
        return points;
    }

}
