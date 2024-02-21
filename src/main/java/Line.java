import java.util.ArrayList;
import java.util.List;

public class Line {
    private final List<LineState> lineStates = new ArrayList<>();

    public Line(final int peopleCount, List<Boolean> results) {
        initializeLineStates(peopleCount, results);
    }

    private void initializeLineStates(int peopleCount, List<Boolean> results) {
        int index = 0;
        lineStates.add(LineState.decideLineState(results.get(index)));
        index += 1;
        for (; index < peopleCount; index++) {
            LineState beforeState = lineStates.get(index - 1);
            lineStates.add(LineState.decideLineStateWithBeforeState(beforeState, results.get(index)));
        }
    }

    public List<LineState> getLineStates() {
        return lineStates;
    }
}
