package domain.ladder;

import domain.generator.BooleanGenerator;
import utils.ErrorMessage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class LadderMaker {

    private static final int MIN_HEIGHT = 1;
    private static final int MAX_HEIGHT = 100;

    private final List<Line> lines = new ArrayList<>();
    private final BooleanGenerator randomBridgeGenerator = () -> new Random().nextBoolean();

    public List<Line> make(int personCount, int height) {
        validateHeight(height);
        for (int i = 0; i < height; i++) {
            lines.add(new Line(personCount, randomBridgeGenerator));
        }
        return Collections.unmodifiableList(lines);
    }

    private void validateHeight(int height) {
        if (height < MIN_HEIGHT || height > MAX_HEIGHT) {
            throw new IllegalArgumentException(ErrorMessage.HEIGHT_ERROR.getMessage());
        }
    }
}
