package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class LadderGenerator {
    public Ladder generate(int countOfPerson, int height) {
        List<Line> lines = new ArrayList<>();
        LineGenerator lineGenerator = new LineGenerator();

        for (int i = 0; i < height; i++) {
            lines.add(lineGenerator.generate(countOfPerson));
        }

        return new Ladder(lines);
    }
}
