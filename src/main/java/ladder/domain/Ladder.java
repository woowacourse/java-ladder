package ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Ladder {
    private final List<HorizontalLine> lines; // top to bottom

    public Ladder(List<HorizontalLine> lines) {
        this.lines = lines;
    }

    public static Ladder create(Height height, int numPosition) {
        List<HorizontalLine> generatedLines = Stream.generate(() -> HorizontalLine.create(numPosition))
                .limit(numPosition)
                .collect(Collectors.toList());

        return new Ladder(generatedLines);
    }

    public static Ladder from(List<HorizontalLine> lines) {
        return new Ladder(lines);
    }

    public LadderMatchingIndice match() {
        Stream<Position> fromPositions = IntStream.range(0, getNumPosition()).mapToObj(Position::create);
        Stream<Position> toPositions = fromPositions.map(position -> nextPosition(position));

        return LadderMatchingIndice.from(toPositions.map(Position::toInt).collect(Collectors.toList()));
    }

    private Position nextPosition(Position from) {
        Position p = from;
        for (HorizontalLine line : lines) {
            p = line.nextPosition(p);
        }
        return p;
    }

    private int getNumPosition() {
        return lines.get(0).getNumPosition();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (HorizontalLine line : lines) {
            sb.append(line.toString());
            sb.append("\n");
        }

        return sb.toString();
    }


}
