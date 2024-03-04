package model.ladder;

import java.util.List;
import java.util.stream.IntStream;
import model.Index;
import model.MatchedIndex;
import model.ladder.line.Line;
import model.ladder.line.LinesGenerator;
import model.people.PersonCount;

public class Ladder {
    private final List<Line> lines;

    private Ladder(final List<Line> lines) {
        this.lines = lines;
    }

    public static Ladder from(final Height height, final PersonCount personCount, final LinesGenerator linesGenerator) {
        int pathCount = personCount.getCount() - 1;
        final List<Line> lines = linesGenerator.generate(height, pathCount);
        validateLineSize(lines.size(), height);
        return new Ladder(lines);
    }

    private static void validateLineSize(final int lineSize, final Height height) {
        if (height.isNotEquals(lineSize)) {
            throw new IllegalArgumentException("높이에 맞지 않는 라인의 수가 생성되었습니다.");
        }
    }

    private MatchedIndex climb(final Index startIndex) {
        Index currentIndex = startIndex;
        for (Line line : lines) {
            currentIndex = line.move(currentIndex);
        }
        return new MatchedIndex(startIndex, currentIndex);
    }

    public List<MatchedIndex> climbAll() {
        return IntStream.range(0, findPersonCount())
                .mapToObj(Index::new)
                .map(this::climb)
                .toList();
    }

    private int findPersonCount() {
        return lines.get(0)
                .getPathsSize() + 1;
    }

    public List<Line> getLines() {
        return lines;
    }
}
