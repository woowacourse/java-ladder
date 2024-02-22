package service;

import domain.Ladder;
import domain.Line;
import domain.RandomPointGenerator;
import java.util.ArrayList;
import java.util.List;

public class LadderMaker {

    public Ladder createLadder(final int personCount, final int height) {
        final List<Line> lines = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            lines.add(Line.createByStrategy(RandomPointGenerator.getInstance(), personCount));
        }
        return new Ladder(lines);
    }
}
