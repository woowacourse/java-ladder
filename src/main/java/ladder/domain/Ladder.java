package ladder.domain;

import ladder.utils.PointsGenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private static final int START = 0;

    private final int numPlayers;
    private List<Line> lines = new ArrayList<>();
    private final PointsGenerator generator;

    public Ladder(final int numPlayers, final int height) {
        generator = new PointsGenerator(numPlayers);
        this.numPlayers = numPlayers;
        for (int i = 0; i < height; i++) {
            lines.add(new Line(generator.generate()));
        }
    }

    public List<Integer> goDown() {
        List<Integer> indices = IntStream.range(START, numPlayers).boxed().collect(Collectors.toList());
        for (Line line : lines) {
            indices = goDownOneLine(indices, line);
        }
        return indices;
    }

    private static List<Integer> goDownOneLine(List<Integer> indices, final Line line) {
        int[] tempIndex = new int[indices.size()];
        for (int i = 0; i < indices.size(); i++) {
            tempIndex[i] = line.determineDirection(indices.get(i)).move(indices.get(i));
        }
        return Arrays.stream(tempIndex).boxed().collect(Collectors.toList());
    }

    public List<Line> getLines() {
        return lines;
    }
}