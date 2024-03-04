package laddergame.model.laddergame;

import java.util.ArrayList;
import java.util.List;
import laddergame.exception.BaseException;

public class LineGenerator {
    private static final int MINIMUM_BOOLEANS_SIZE = 2;

    private final List<LineConnectionDecision> decisions;
    private LineState beforeState;

    public LineGenerator(List<LineConnectionDecision> decisions) {
        validateLineConnectionDecisionSize(decisions);
        this.decisions = decisions;
    }

    private void validateLineConnectionDecisionSize(List<LineConnectionDecision> decisions) {
        if (decisions.size() < MINIMUM_BOOLEANS_SIZE) {
            String message = "크기가 " + MINIMUM_BOOLEANS_SIZE + "보다 작은 선 연결 결정은 허용되지 않습니다.";
            throw new BaseException(message);
        }
    }

    public Line generate() {
        List<LineState> lineStates = new ArrayList<>();
        for (int index = 0; index < decisions.size(); index++) {
            LineConnectionDecision decision = decisions.get(index);
            LineState lineState = generateLineState(index, decision);
            lineStates.add(lineState);
            beforeState = lineState;
        }
        return new Line(lineStates);
    }

    private LineState generateLineState(int index, LineConnectionDecision decision) {
        if (index == 0) {
            return LineState.decideLineState(decision);
        }
        if (index == decisions.size() - 1) {
            return LineState.decideLineState(beforeState);
        }
        return LineState.decideLineState(beforeState, decision);
    }
}
