package domain.ladder;

import domain.generator.BooleanGenerator;
import domain.generator.RandomBooleanGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LadderMaker {

    private static final String HEIGHT_ERROR_MESSAGE = "사다리 높이는 1이상 100이하의 자연수만 가능합니다.";
    private static final int MIN_HEIGHT = 1;
    private static final int MAX_HEIGHT = 100;

    private final List<Line> lines = new ArrayList<>();
    private final BooleanGenerator booleanGenerator = new RandomBooleanGenerator();

    public List<Line> make(int personCount, int height) {
        validateHeight(height);
        for (int i = 0; i < height; i++) {
            lines.add(new Line(personCount, booleanGenerator));
        }
        return Collections.unmodifiableList(lines);
    }

    private void validateHeight(int height) {
        if (height < MIN_HEIGHT || height > MAX_HEIGHT) {
            throw new IllegalArgumentException(HEIGHT_ERROR_MESSAGE);
        }
    }
}
