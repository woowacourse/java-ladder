package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class LadderPositions {
    private static final int MIN_LADDER_POSITIONS_LENGTH = 2;
    private static final int MAX_LADDER_POSITIONS_LENGTH = 10;
    public final List<Integer> positions;

    public LadderPositions(int length) {
        validatePositionsLength(length);
        this.positions = IntStream.range(0, length).boxed().toList();
    }

    private LadderPositions(List<Integer> positions) {
        validatePosition(positions);
        this.positions = positions;
    }

    public List<Integer> getPositions() {
        return positions;
    }

    public Integer getPosition(int index) {
        return positions.get(index);
    }

    public int count() {
        return positions.size();
    }
    
    public LadderPositions calculatePosition(Row row) {
        List<Bridge> bridges = row.getBridges();
        List<Integer> calculatedPosition = swapPosition(bridges);
        return new LadderPositions(Collections.unmodifiableList(calculatedPosition));
    }

    private List<Integer> swapPosition(List<Bridge> bridges) {
        List<Integer> calculatedPosition = new ArrayList<>(positions);
        IntStream.range(1, positions.size())
                .forEach(index -> swapIfBridgeExist(index, bridges.get(index - 1), calculatedPosition));
        return calculatedPosition;
    }

    private void validatePosition(List<Integer> positions) {
        if (positions.size() < MIN_LADDER_POSITIONS_LENGTH || positions.size() > MAX_LADDER_POSITIONS_LENGTH) {
            throw new LadderGameException(ExceptionType.INVALID_LADDER_POSITIONS_RANGE);
        }
    }

    private void validatePositionsLength(int length) {
        if (length < MIN_LADDER_POSITIONS_LENGTH || length > MAX_LADDER_POSITIONS_LENGTH) {
            throw new LadderGameException(ExceptionType.INVALID_LADDER_POSITIONS_RANGE);
        }
    }

    private void swapIfBridgeExist(int index, Bridge bridge, List<Integer> calculatedPosition) {
        if (bridge == Bridge.EXIST) {
            Collections.swap(calculatedPosition, index, index - 1);
        }
    }
}
