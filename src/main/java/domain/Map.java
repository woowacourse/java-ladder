package domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import util.BooleanGenerator;

public class Map {

    private final Height height;
    private final Weight weight;
    private final Ladder ladder;

    public Map(Height height, Weight weight, BooleanGenerator booleanGenerator) {
        this.height = height;
        this.weight = weight;
        this.ladder = generate(booleanGenerator);
    }

    private Ladder generate(BooleanGenerator booleanGenerator) {
        List<Line> lines = IntStream.range(0, height.getHeight())
                                    .mapToObj((count) -> new Line(weight.getWeight(), booleanGenerator))
                                    .collect(Collectors.toList());
        return new Ladder(lines);
    }

    public List<Line> getLines() {
        return ladder.getLines();
    }
}
