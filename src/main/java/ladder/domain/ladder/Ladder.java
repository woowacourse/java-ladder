package ladder.domain.ladder;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;
import ladder.domain.ladder.generator.RungGenerator;

public class Ladder {
    private static final int MINIMUM_HEIGHT = 1;
    private static final int MAXIMUM_HEIGHT = 30;

    private final List<Line> lines;

    private Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public static Ladder of(int height, int playerCount, RungGenerator rungGenerator) {
        validateHeightRange(height);

        List<Line> lines = Stream.generate(() -> new Line(playerCount, rungGenerator))
                .limit(height)
                .toList();

        return new Ladder(lines);
    }

    private static void validateHeightRange(int height) {
        if (MINIMUM_HEIGHT > height || height > MAXIMUM_HEIGHT) {
            throw new IllegalArgumentException(
                    String.format("사다리의 높이는 %d이상 %d이하여야 합니다.", MINIMUM_HEIGHT, MAXIMUM_HEIGHT));
        }
    }

    public int findEndIndex(int index) {
        validateIndexRange(index);

        int currentIndex = index;
        for (Line line : lines) {
            currentIndex = line.findConnectedIndex(currentIndex);
        }

        return currentIndex;
    }

    private void validateIndexRange(int index) {
        int columSize = lines.get(0).getRungs().size();

        if (0 > index || index > columSize) {
            throw new IllegalArgumentException("index가 범위를 벗어났습니다.");
        }
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }
}
