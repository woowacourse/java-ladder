package ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
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
        if (ladderHeight < 1 || ladderHeight > 100) {
            throw new IllegalArgumentException("사다리 높이는 1이상 100 이하만 입력할 수 있습니다.");
        }
    }

    private Line createLine(BarGenerator barGenerator, int peopleSize) {
        Line line = new Line();
        line.addBars(peopleSize, barGenerator);
        return line;
    }

    public List<Line> getLines() {
        return this.lines;
    }
}
