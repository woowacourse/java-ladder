package service;

import domain.Height;
import domain.Ladder;
import domain.Line;
import java.util.ArrayList;
import java.util.List;
import util.LineStrategy;

public class LadderService {
    private final LineStrategy lineStrategy;

    public LadderService(LineStrategy lineStrategy) {
        this.lineStrategy = lineStrategy;
    }

    public Ladder createLadder(Height height, int playerCount) {
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < height.getHeight(); i++) {
            lines.add(lineStrategy.generate(playerCount));
        }
        return new Ladder(lines, playerCount);
    }
}
