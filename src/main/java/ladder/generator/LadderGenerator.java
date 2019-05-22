package ladder.generator;

import ladder.domain.Ladder;
import ladder.domain.Line;

import java.util.ArrayList;
import java.util.List;

public class LadderGenerator {

    private LadderGenerator() {
    }

    public static Ladder makeLadder(int countOfPlayers, int countOfLines, LineGenerator LineGenerator) {
        List<Line> lines = new ArrayList<>();

        for (int i = 0; i < countOfLines; i++) {
            lines.add(LineGenerator.makeLine(countOfPlayers));
        }
        return new Ladder(lines);
    }
}
