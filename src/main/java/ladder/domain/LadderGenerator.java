package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class LadderGenerator {
    public static Ladder generate(int height, int numberOfPeople) {
        List<Line> lines = new ArrayList<>();

        for (int i = 0; i < height; i++) {
            lines.add(new Line(numberOfPeople));
        }

        return new Ladder(lines);
    }
}
