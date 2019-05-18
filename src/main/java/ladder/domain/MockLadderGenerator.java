package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class MockLadderGenerator implements LadderBuilder {
    @Override
    public Ladder generate(int height, int numberOfPeople) {
        List<Line> lines = new ArrayList<>();

        for (int i = 0; i < height; i++) {
            lines.add(new MockLineGenerator().generate(numberOfPeople));
        }

        return new Ladder(lines);
    }
}
