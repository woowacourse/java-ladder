package ladder.domain.ladder;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;
import ladder.domain.ladder.generator.RungGenerator;

public class Ladder {

    private final int playerCount;
    private final List<Line> lines;

    public Ladder(int playerCount, LadderHeight ladderHeight, RungGenerator rungGenerator) {
        this.playerCount = playerCount;
        this.lines = generateLines(playerCount, ladderHeight.getHeight(), rungGenerator);

    }

    private List<Line> generateLines(int playerCount, int height, RungGenerator rungGenerator) {
        return Stream.generate(() -> new Line(playerCount, rungGenerator))
                .limit(height)
                .toList();
    }

    public int findEndIndex(int index) {
        validateIndexRange(index);

        for (Line line : lines) {
            index = line.findConnectedIndex(index);
        }

        return index;
    }

    private void validateIndexRange(final int index) {
        if (0 > index || index >= playerCount) {
            throw new IllegalArgumentException("시작점은 0 이상 참가자 수 미만이어야 합니다.");
        }
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }
}
