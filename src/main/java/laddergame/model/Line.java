package laddergame.model;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private final List<LineState> lineStates = new ArrayList<>();
    private LineState beforeState;

    public Line(List<Boolean> results) {
        for (int i = 0; i < results.size(); i++) {
            boolean result = results.get(i);
            LineState lineState = generateLineState(i, result);
            lineStates.add(lineState);
            beforeState = lineState;
        }
    }

    private LineState generateLineState(int index, boolean result) {
        if (index == 0) {
            return LineState.decideLineState(result);
        }
        return LineState.decideLineStateWithBeforeState(beforeState, result);
    }

    public List<LineState> getLineStates() {
        return lineStates;
    }
}
