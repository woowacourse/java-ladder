package ladder.domain;

import ladder.utils.LineStrategy;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Line {
    private static final boolean LINKED = true;
    private final List<Boolean> bridges;

    public Line(LineStrategy lineStrategy, int bridgeCount) {
        this.bridges = lineStrategy.generate(bridgeCount);
        validate();
    }

    public int moveFrom(int startPosition) {
        validateOutBound(startPosition);
        if (isRightMoveAble(startPosition) && isBridgeExist(startPosition)) {
            return startPosition + 1;
        }
        if (isLeftMoveAble(startPosition) && isBridgeExist(startPosition - 1)) {
            return startPosition - 1;
        }
        return startPosition;
    }

    private boolean isBridgeExist(int startPosition) {
        return bridges.get(startPosition) == LINKED;
    }

    private boolean isRightMoveAble(int position) {
        return position + 1 <= bridges.size();
    }

    private boolean isLeftMoveAble(int position) {
        return position - 1 >= 0;
    }

    private void validate() {
        if (isContinuousLine(bridges)) {
            throw new IllegalArgumentException("라인에 연속으로 연결된 다리는 생성될 수 없습니다.");
        }
    }

    private boolean isContinuousLine(List<Boolean> line) {
        return IntStream.range(0, line.size() - 1)
                .anyMatch(idx -> isContinuous(line, idx));
    }

    private boolean isContinuous(List<Boolean> line, int idx) {
        return line.get(idx) && line.get(idx + 1);
    }

    private void validateOutBound(int startPoint) {
        if ((startPoint < 0) || (startPoint > bridges.size())) {
            throw new IllegalArgumentException("line 범위 밖의 시작점입니다.");
        }
    }

    public List<Boolean> getLine() {
        return Collections.unmodifiableList(bridges);
    }
}
