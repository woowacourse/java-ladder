package laddergame.model.laddergame;

import java.util.List;
import java.util.stream.IntStream;

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
        IntStream.range(0, lineStates.size() - 1)
                .forEach(i -> validateEachLineState(lineStates.get(i), lineStates.get(i + 1)));
    }

    private void validateEachLineState(LineState before, LineState current) {
        if (before.isStart() && current.isStart() || before.isEnd() && current.isEnd()) {
            throw new IllegalArgumentException("[ERROR] START와 END는 연속될 수 없습니다.");
        }
    }

    private void validateInvalidPosition(List<LineState> lineStates) {
        LineState firstState = lineStates.get(0);
        LineState lastState = lineStates.get(lineStates.size() - 1);
        if (firstState.isEnd() || lastState.isStart()) {
            throw new IllegalArgumentException("[ERROR] 선은 END로 시작하거나 START로 끝날 수 없습니다.");
        }
    }

    public int move(int index) {
        LineState lineState = lineStates.get(index);
        if (lineState.isStart()) {
            return index + 1;
        }
        if (lineState.isEnd()) {
            return index - 1;
        }
        return index;
    }

    public List<LineState> getLineStates() {
        return lineStates;
    }
}
