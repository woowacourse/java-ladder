package domain.model;

import domain.type.Line;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class Layer {

    private final List<Line> lines;
    private static final Random randomGenerator = new Random();

    private Layer(List<Line> lines) {
        this.lines = lines;
    }

    public static Layer makeLayerByRandom(final int size) {
        List<Line> lines = new ArrayList<>();
        IntStream.range(0, size).mapToObj(index -> lines).forEach(Layer::makeLine);
        return new Layer(lines);
    }

    private static void makeLine(final List<Line> lines) {
        boolean randomBoolean = randomGenerator.nextBoolean();
        if (randomBoolean &&
            (lines.isEmpty() || lines.get(lines.size() - 1).equals(Line.UNCONNECTED))) {
            lines.add(Line.CONNECTED);
            return;
        }
        lines.add(Line.UNCONNECTED);
    }

    public List<Line> getLines() {
        return new ArrayList<>(lines);
    }
}
