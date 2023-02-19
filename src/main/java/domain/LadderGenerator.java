package domain;

import java.util.ArrayList;
import java.util.List;
import utils.NumberGenerator;

public class LadderGenerator {

    private static final int NUMBER_OF_PEOPLE_TO_WIDTH_SCALE = 1;

    private final NumberGenerator numberGenerator;

    public LadderGenerator(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public Ladder generate(int numberOfPeople,
                           LadderHeight ladderHeight) {
        List<Line> lines = new ArrayList<>();
        int width = numberOfPeople - NUMBER_OF_PEOPLE_TO_WIDTH_SCALE;
        int height = ladderHeight.getLadderHeight();

        while (height-- > 0) {
            lines.add(Line.create(numberGenerator, width));
        }
        return new Ladder(lines, ladderHeight);
    }
}
