package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private static final int MINIMUM_LADDER_HEIGHT = 1;
    private static final int MAXIMUM_LADDER_HEIGHT = 100;
    
    private final List<Line> lines;

    public Ladder(BarGenerator barGenerator, int ladderHeight, int peopleSize) {
        validateRange(ladderHeight);
        this.lines = createLines(barGenerator, ladderHeight, peopleSize);
    }

    private List<Line> createLines(BarGenerator barGenerator, int ladderHeight, int peopleSize) {
        return IntStream.range(0, ladderHeight)
                .mapToObj(lineCount -> createLine(barGenerator, peopleSize))
                .collect(Collectors.toUnmodifiableList());
    }

    private void validateRange(int ladderHeight) {
        if (ladderHeight < MINIMUM_LADDER_HEIGHT || ladderHeight > MAXIMUM_LADDER_HEIGHT) {
            throw new IllegalArgumentException("사다리 높이는 1이상 100 이하만 입력할 수 있습니다.");
        }
    }

    private Line createLine(BarGenerator barGenerator, int peopleSize) {
        return new Line(barGenerator, peopleSize);
    }
    
    public List<Integer> getMovedPositions() {
        List<Integer> movedPositions = List.of(0,1,2,3);
        for (Line line : lines) {
            movedPositions = line.getMovedPositions(movedPositions);
        }
        
        return movedPositions;
    }
    
    public List<Line> getLines() {
        return this.lines;
    }
}
