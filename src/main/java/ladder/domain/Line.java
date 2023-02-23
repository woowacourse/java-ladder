package ladder.domain;

import ladder.domain.ladderNode.Position;
import ladder.utils.LineStrategy;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Line {
    private static final boolean LINKED = true;
    private static final int MOVE_DISTANCE = 1;
    private static final int MIN_LINE_BOUND = 0;

    private final List<Boolean> bridges;

    public Line(LineStrategy lineStrategy, int bridgeCount) {
        this.bridges = lineStrategy.generate(bridgeCount);
        validate();
    }

    public Position moveFrom(Position startPosition) {
        int position = startPosition.getPosition();
        validateOutBound(position);

        if (isRightMoveAble(position) && isBridgeExist(position)) {
            return new Position(position + MOVE_DISTANCE);
        }
        if (isLeftMoveAble(position) && isBridgeExist(position - MOVE_DISTANCE)) {
            return new Position(position - MOVE_DISTANCE);
        }
        return new Position(position);
    }

    private boolean isBridgeExist(int startPosition) {
        return bridges.get(startPosition) == LINKED;
    }

    private boolean isRightMoveAble(int position) {
        return position + MOVE_DISTANCE <= bridges.size();
    }

    private boolean isLeftMoveAble(int position) {
        return position - MOVE_DISTANCE >= MIN_LINE_BOUND;
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
        return line.get(idx) && line.get(idx + MOVE_DISTANCE);
    }

    private void validateOutBound(int startPoint) {
        if ((startPoint < MIN_LINE_BOUND) || (startPoint > bridges.size())) {
            throw new IllegalArgumentException("line 범위 밖의 시작점입니다.");
        }
    }

    public List<Boolean> getLine() {
        return Collections.unmodifiableList(bridges);
    }
}
