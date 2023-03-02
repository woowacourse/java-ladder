package domain.ladder;

import java.util.ArrayList;
import java.util.List;

public class LadderGenerator {

    private final LineGenerator lineGenerator;

    public LadderGenerator(LineGenerator lineGenerator) {
        this.lineGenerator = lineGenerator;
    }

    public Ladder generate(int numberOfPeople,
                           LadderHeight ladderHeight) {
        List<Line> lines = new ArrayList<>();
        int height = ladderHeight.getLadderHeight();

        while (height-- > 0) {
            lines.add(lineGenerator.generate(numberOfPeople));
        }
        return new Ladder(lines);
    }
}
