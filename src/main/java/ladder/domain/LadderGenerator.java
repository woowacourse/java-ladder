package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class LadderGenerator {
    public Ladder generate(int height, int numberOfPeople, LineGenerator lineGenerator) {
        List<Line> lines = new ArrayList<>();

        for (int i = 0; i < height; i++) {
            lines.add(lineGenerator.generate(numberOfPeople));
        }

        return new Ladder(lines);
    }
}
