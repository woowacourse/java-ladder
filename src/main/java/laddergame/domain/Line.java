package laddergame.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import laddergame.dto.LineBuildResult;

public class Line {
    private List<Boolean> points;

    public Line(final int playerCount) {
        this.points = new ArrayList<>(Collections.nCopies(playerCount - 1, Boolean.FALSE));
    }

    public void buildBridge(LineBuildResult isBridgeBuilt) {
        validate(isBridgeBuilt);
        this.points = isBridgeBuilt.buildResults();
    }

    private void validate(final LineBuildResult isBridgeBuilt) {
        boolean isTrue = false;
        for (Boolean previous : isBridgeBuilt.buildResults()) {
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
