package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Line {
    private static final int BOTH_ENDS_COUNT = 2;
    
    private final List<Direction> line;

    public Line(BarGenerator barGenerator, int peopleSize) {
        line = createLine(barGenerator, peopleSize);
    }
    
    private List<Direction> createLine(BarGenerator barGenerator, int peopleSize) {
        List<Direction> line = new ArrayList<>();
        addFirstDirection(barGenerator, line);
        addMiddleDirections(barGenerator, peopleSize, line);
        addLastDirection(line);
        return line;
    }
    
    private void addFirstDirection(BarGenerator barGenerator, List<Direction> line) {
        line.add(Direction.createFirst(barGenerator));
    }
    
    private void addMiddleDirections(BarGenerator barGenerator, int peopleSize, List<Direction> line) {
        for (int middleDirectionCount = 0; middleDirectionCount < peopleSize - BOTH_ENDS_COUNT; middleDirectionCount++) {
            line.add(getLastDirection(line).createNext(barGenerator));
        }
    }
    
    private void addLastDirection(List<Direction> line) {
        line.add(getLastDirection(line).createLast());
    }
    
    private Direction getLastDirection(List<Direction> line) {
        return line.get(getLineLastIndex(line));
    }
    
    private int getLineLastIndex(List<Direction> line) {
        return line.size() - 1;
    }
    
    public List<Integer> getMovedPositions(List<Integer> positions) {
        return positions.stream()
                .map(position -> getCurrentPositionDirection(position).getMovedPosition(position))
                .collect(Collectors.toUnmodifiableList());
    }
    
    private Direction getCurrentPositionDirection(Integer position) {
        return line.get(position);
    }
    
    public List<Direction> getLine() {
        return line;
    }
}
