package domain;

import java.util.ArrayList;
import java.util.List;

public class LadderGenerator {

    private static final int NUMBER_OF_PEOPLE_TO_WIDTH_SCALE = 1;

    private final LineGenerator lineGenerator;

    public LadderGenerator(LineGenerator lineGenerator) {
        this.lineGenerator = lineGenerator;
    }

    public Ladder generate(int numberOfPeople,
                           LadderHeight ladderHeight) {
        List<Line> lines = new ArrayList<>();
        int width = numberOfPeople - NUMBER_OF_PEOPLE_TO_WIDTH_SCALE;
        int height = ladderHeight.getLadderHeight();

        while (height-- > 0) {
            lines.add(lineGenerator.generate(width));
        }
        return new Ladder(lines, ladderHeight);
    }
}
