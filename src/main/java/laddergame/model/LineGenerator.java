package laddergame.model;

import java.util.ArrayList;
import java.util.List;

public class LineGenerator {
    private static final int MINIMUM_BOOLEANS_SIZE = 2;

    private final List<Boolean> booleans;
    private LineState beforeState;

    public LineGenerator(List<Boolean> booleans) {
        validateBooleansSize(booleans);
        this.booleans = booleans;
    }

    private void validateBooleansSize(List<Boolean> booleans) {
        if (booleans.size() < MINIMUM_BOOLEANS_SIZE) {
            throw new IllegalArgumentException("크기가 2보다 작은 불린리스트는 들어올 수 없습니다.");
        }
    }

    public Line generate() {
        List<LineState> lineStates = new ArrayList<>();
        for (int index = 0; index < booleans.size(); index++) {
            boolean result = booleans.get(index);
            LineState lineState = generateLineState(index, result);
            lineStates.add(lineState);
            beforeState = lineState;
        }
        return new Line(lineStates);
    }

    private LineState generateLineState(int index, boolean decision) {
        if (index == 0) {
            return LineState.decideLineState(decision);
        }
        if (index == booleans.size() - 1) {
            return LineState.decideLineState(beforeState);
        }
        return LineState.decideLineState(beforeState, decision);
    }
}
