package ladder.model;

import ladder.model.impl.DefaultLadder;
import ladder.model.impl.LineFactory;

import java.util.ArrayList;
import java.util.List;

class LadderFactory {
    static Ladder createLadder(int sizeOfPerson, int height) {
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            lines.add(LineFactory.createLine(sizeOfPerson));
        }
        return new DefaultLadder(sizeOfPerson, lines);
    }
}
