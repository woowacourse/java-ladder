package model;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private final List<LineState> lineStates = new ArrayList<>();

    public Line(final int peopleCount, List<Boolean> makeLadderDecision) {
        validateCorrespondingInputSize(peopleCount, makeLadderDecision);
        initializeLineStates(peopleCount, makeLadderDecision);
    }

    private void initializeLineStates(int peopleCount, List<Boolean> makeLadderDecision) {
        int index = 0;
        lineStates.add(LineState.decideLineState(makeLadderDecision.get(index)));
        index += 1;
        for (; index < peopleCount; index++) {
            LineState beforeState = lineStates.get(index - 1);
            LineState currentState = LineState.decideLineStateWithBeforeState(beforeState, makeLadderDecision.get(index));
            lineStates.add(currentState);
        }
    }

    public List<LineState> getLineStates() {
        return lineStates;
    }

    private void validateCorrespondingInputSize(int peopleCount, List<Boolean> makeLadderDecision) {
        if (peopleCount != makeLadderDecision.size()) {
            throw new IllegalArgumentException("[ERROR] 랜덤 값 생성 개수가 총 참여자 수와 일치하지 않습니다.");
        }
    }
}
