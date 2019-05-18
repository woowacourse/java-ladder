package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class LadderGenerator implements LadderBuilder {
    @Override
    public Ladder generate(int height, int numberOfPeople) {
        List<Line> lines = new ArrayList<>();

        for (int i = 0; i < height; i++) {
            lines.add(new LineGenerator().generate(numberOfPeople));
        }

        return new Ladder(lines);
    }
}
