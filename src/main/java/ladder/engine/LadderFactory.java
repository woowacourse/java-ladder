package ladder.engine;

import ladder.engine.infra.DefaultLadder;
import ladder.engine.infra.LadderLineFactory;

import java.util.ArrayList;
import java.util.List;

public class LadderFactory {
    public static Ladder createLadder(int sizeOfPerson, int height) {
        List<LadderLine> lines = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            lines.add(LadderLineFactory.createLine(sizeOfPerson));
        }
        return new DefaultLadder(lines);
    }
}
