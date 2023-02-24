package domain.ladder;

import domain.generator.BooleanGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LadderMaker {

    private final List<Line> lines = new ArrayList<>();
    private final BooleanGenerator randomBridgeGenerator = () -> new Random().nextBoolean();

    public LadderMaker(int personCount, Height height) {
        for (int i = 0; i < height.getHeight(); i++) {
            lines.add(new Line(personCount, randomBridgeGenerator));
        }
    }

    public List<Line> getLines() {
        return lines;
    }
}
