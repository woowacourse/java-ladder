package domain.ladder;

import domain.generator.BooleanGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Ladder {

    private final List<Line> lines = new ArrayList<>();
    private final BooleanGenerator randomBridgeGenerator = () -> new Random().nextBoolean();

    public Ladder(int personCount, Height height) {
        for (int i = 0; i < height.getHeight(); i++) {
            lines.add(new Line(personCount, randomBridgeGenerator));
        }
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }
}
