package laddergame.model;

import java.util.List;

public class Line {
    private final List<LineState> lineStates;

    public Line(List<LineState> lineStates) {
        validateLineState(lineStates);
        this.lineStates = lineStates;
    }

    private void validateLineState(List<LineState> lineStates) {
        validateContinuousStartOrEnd(lineStates);
        validateInvalidPosition(lineStates);
    }

    private void validateContinuousStartOrEnd(List<LineState> lineStates) {
        for (int i = 0; i < lineStates.size() - 1; i++) {
            LineState current = lineStates.get(i);
            LineState next = lineStates.get(i + 1);
            if (LineState.START.equals(current) && LineState.START.equals(next)
                    || LineState.END.equals(current) && LineState.END.equals(next)) {
                throw new IllegalStateException("START와 END는 연속될 수 없습니다.");
            }
        }
    }

    private void validateInvalidPosition(List<LineState> lineStates) {
        LineState firstState = lineStates.get(0);
        LineState lastState = lineStates.get(lineStates.size() - 1);
        if (LineState.END.equals(firstState) || LineState.START.equals(lastState)) {
            throw new IllegalStateException("선은 END로 시작하거나 START로 끝날 수 없습니다.");
        }
    }

    public int move(int index) {
        if (LineState.START.equals(lineStates.get(index))) {
            return index + 1;
        }
        if (LineState.END.equals(lineStates.get(index))) {
            return index - 1;
        }
        return index;
    }

    public List<LineState> getLineStates() {
        return lineStates;
    }
}
