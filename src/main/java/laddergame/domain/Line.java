package laddergame.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;
import laddergame.dto.LineBuildResult;

public class Line {
    private static final String BRIDGE_SEQUENCE_ERROR = "연속적인 다리 건설은 허용하지 않습니다.";
    private List<Boolean> points;

    public Line(final int playerCount) {
        this.points = new ArrayList<>(Collections.nCopies(playerCount - 1, Boolean.FALSE));
    }

    public void buildBridge(LineBuildResult isBridgeBuilt) {
        validate(isBridgeBuilt);
        this.points = isBridgeBuilt.buildResults();
    }

    private void validate(final LineBuildResult buildResults) {
        boolean hasTrueSequence = IntStream.range(0, buildResults.buildResults().size() - 1)
                .anyMatch(i -> buildResults.buildResults().get(i) && isAdjacentSame(buildResults, i));

        if (hasTrueSequence) {
            throw new IllegalStateException(BRIDGE_SEQUENCE_ERROR);
        }
    }

    private boolean isAdjacentSame(LineBuildResult buildResults, int index) {
        return buildResults.buildResults().get(index) == buildResults.buildResults().get(index + 1);
    }

    public boolean isBuilt(final int position) {
        return points.get(position);
    }

    public List<Boolean> getPoints() {
        return points;
    }

}
