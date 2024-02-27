package domain;

import utils.RandomGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Ladder {

    private static final int MAX_LADDER_HEIGHT = 100;

    private final List<Line> lines;

    public Ladder(final List<Line> line) {
        lines = line;
    }

    public static Ladder of(final int maxHeight, final int personCount) {
        validateMaxHeight(maxHeight);

        List<Line> randomLines = new ArrayList<>();
        IntStream.range(0, maxHeight)
                .forEach(iterator -> randomLines.add(Line.of(personCount, new RandomGenerator())));
        return new Ladder(randomLines);
    }

    public int climb(int position) {
        for (Line line : lines) {
            position = line.moveFrom(position);
        }
        return position;
    }

    private static void validateMaxHeight(final int maxHeight) {
        if (maxHeight > MAX_LADDER_HEIGHT) {
            throw new IllegalArgumentException(String.format("입력된 값: %d, 사다리 높이는 최대 %d입니다.", maxHeight, MAX_LADDER_HEIGHT));
        }
    }

    public List<Line> getLines() {
        return lines;
    }

    public int getHeight() {
        return lines.size();
    }
}
