package ladder.generator;

import ladder.domain.Ladder;
import ladder.domain.Line;

import java.util.ArrayList;
import java.util.List;

public class LadderGenerator {

    public Ladder makeLadder(int countOfPlayers, int countOfLines) {
        List<Line> lines = new ArrayList<>();
        LineGenerator lineGenerator = new LineGenerator();

        for (int i = 0; i < countOfLines; i++) {
            lines.add(lineGenerator.makeLine(countOfPlayers));
        }
        return new Ladder(lines);
    }
}
