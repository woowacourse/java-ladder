package ladder.domain.ladder;

import ladder.domain.generator.BooleanGenerator;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Ladder {
    private final List<Line> lines;

    public Ladder(final int playerCount, final int height, final BooleanGenerator booleanGenerator) {
        this.lines = generateLines(playerCount, height, booleanGenerator);
    }

    private List<Line> generateLines(int playerCount, int height, BooleanGenerator booleanGenerator) {
        return Stream.generate(() -> generateLine(playerCount, booleanGenerator))
                .limit(height)
                .toList();
    }

    private Line generateLine(final int playerCount, final BooleanGenerator booleanGenerator) {
        return IntStream.range(0, playerCount - 1)
                .mapToObj(index -> booleanGenerator.generate())
                .collect(Collectors.collectingAndThen(Collectors.toList(), Line::new));
    }

    public int countLine() {
        return lines.size();
    }

    public List<Rung> findRungsByIndex(final int index) {
        final Line line = lines.get(index);
        return line.getRungs();
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }
}
