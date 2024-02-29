package domain;

import utils.Generator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Ladder {

    private static final int MAX_LADDER_HEIGHT = 100;

    private final List<Line> lines;

    private Ladder(final List<Line> line) {
        lines = line;
    }

    public static Ladder of(final int height, final int personCount, Generator generator) {
        validateMaxHeight(height);
        List<Line> lines = generateLines(height, personCount, generator);
        return new Ladder(lines);
    }

    public int climb(int position) {
        for (Line line : lines) {
            position = line.moveFrom(position);
        }
        return position;
    }

    private static List<Line> generateLines(final int height, final int personCount, final Generator generator) {
        List<Line> lines = new ArrayList<>();
        IntStream.range(0, height)
                .forEach(iterator -> lines.add(Line.of(personCount, generator)));
        return lines;
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
