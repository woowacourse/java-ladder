package ladder.domain;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Line {
    private final List<Direction> line;

    public Line(BarGenerator barGenerator, int peopleSize) {
        line = createLine(barGenerator, peopleSize);
    }
    
    private List<Direction> createLine(BarGenerator barGenerator, int peopleSize) {
        LinkedList<Direction> line = new LinkedList<>();
        addFirstDirection(barGenerator, line);
        addMiddleDirections(barGenerator, peopleSize, line);
        addLastDirection(line);
        return line;
    }
    
    private void addFirstDirection(BarGenerator barGenerator, LinkedList<Direction> line) {
        line.add(Direction.createFirst(barGenerator));
    }
    
    private void addMiddleDirections(BarGenerator barGenerator, int peopleSize, LinkedList<Direction> line) {
        IntStream.range(0, peopleSize - 2)
                .mapToObj(middleDirectionCount -> getLastDirection(line).createNext(barGenerator))
                .forEach(line::add);
    }
    
    private void addLastDirection(LinkedList<Direction> line) {
        line.add(getLastDirection(line).createLast());
    }
    
    private Direction getLastDirection(LinkedList<Direction> line) {
        return line.getLast();
    }
    
    public List<Integer> movedPositions(List<Integer> positions) {
        return positions.stream()
                .map(position -> getCurrentPositionDirection(position).getAdjustedPosition(position))
                .collect(Collectors.toUnmodifiableList());
    }
    
    private Direction getCurrentPositionDirection(Integer position) {
        return line.get(position);
    }
    
    public List<Direction> getLine() {
        return line;
    }
}
