package domain;

import java.util.*;
import java.util.stream.IntStream;

public class Lines {
    private List<Line> lines;
    private final int height;
    private final LineGenerator lineGenerator;

    public Lines(final int height, LineGenerator lineGenerator) {
        this.height = height;
        this.lineGenerator = lineGenerator;
        this.lines = new ArrayList<>();
    }

    public Map<Name, Integer> playGame(Names names) {
        Map<Name, Integer> gameResult = new LinkedHashMap<>();

        for (int i = 0; i < names.size(); i++) {
            gameResult.put(names.getNames().get(i), i);
        }

        for (Name name : names.getNames()) {
            getLines().forEach(line -> {
                Integer currentIndex = gameResult.get(name);
                Direction direction = line.nextPosition(currentIndex);
                gameResult.put(name, move(currentIndex, direction));
            });
        }

        return gameResult;
    }

    private int move(int index, Direction direction) {
        if (direction == Direction.LEFT) {
            return --index;
        }
        if (direction == Direction.RIGHT) {
            return ++index;
        }
        return index;
    }

    private void createLines() {
        this.lines = IntStream.range(0, height)
                .mapToObj(index -> new Line(createPoints()))
                .toList();
    }

    private List<Point> createPoints() {
        return lineGenerator.createPoints();
    }

    public List<Line> getLines() {
        if (lines.isEmpty()) {
            createLines();
        }
        return Collections.unmodifiableList(lines);
    }
}
