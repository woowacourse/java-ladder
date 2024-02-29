package ladder;

import java.util.Collections;
import java.util.List;
import java.util.function.BooleanSupplier;
import java.util.stream.Stream;

public class Ladder {

    private final List<Line> lines;

    Ladder(List<Line> lines) {
        validateSameSize(lines);
        this.lines = lines;
    }

    public Ladder(int playerCount, int height, BooleanSupplier connectionAttemptSupplier) {
        this.lines = Stream.generate(() -> Line.fromConnectionAttemptSupplier(connectionAttemptSupplier, playerCount))
                .limit(height)
                .toList();
    }

    public int climbDown(int startIndex) {
        Index resultIndex = Index.of(startIndex);
        for (final Line line : lines) {
            resultIndex = line.move(resultIndex);
        }
        return resultIndex.toInt();
    }

    private void validateSameSize(List<Line> lines) {
        int count = (int) lines.stream()
                .mapToInt(Line::size)
                .distinct()
                .count();

        if (count != 1) {
            throw new IllegalArgumentException("각 줄의 크기가 다릅니다.");
        }
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }
}
