package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class LadderGenerator {
    public static Ladder generate(int height, int numberOfPlayers, LineGenerator lineGenerator) {
        List<Line> lines = new ArrayList<>();

        for (int i = 0; i < height; i++) {
            lines.add(lineGenerator.generate(numberOfPlayers));
        }

        return new Ladder(lines);
    }
}
