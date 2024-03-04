package model;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private final List<LineState> lineStates = new ArrayList<>();

    public Line(List<Boolean> determineLungExists) {
        int lastMiddleStateIndex = determineLungExists.size() - 1;
        lineStates.add(LineState.decideFirstLineState(determineLungExists.get(0)));
        for (int middleIndex = 1; middleIndex <= lastMiddleStateIndex; middleIndex++) {
            LineState beforeState = lineStates.get(middleIndex - 1);
            LineState currentState = LineState.decideMiddleLineState(beforeState, determineLungExists.get(middleIndex));
            lineStates.add(currentState);
        }
        lineStates.add(LineState.decideLastLineState(lineStates.get(lastMiddleStateIndex)));
    }

    public int move(int index) {
        return index + LineState.findDirection(lineStates.get(index));
    }

    public List<LineState> getLineStates() {
        return lineStates;
    }
}
