package ladder.service;

import ladder.domain.Height;
import ladder.domain.Ladder;
import ladder.domain.Line;
import java.util.ArrayList;
import java.util.List;
import ladder.util.LineStrategy;

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
