package domain.ladder;

import java.util.ArrayList;
import java.util.List;
import util.BooleanGenerator;

public class LadderGenerator {
    public static final int MAX_HEIGHT = 10;
    public static final int MIN_HEIGHT = 2;
    public static final String INVALID_LADDER_HEIGHT_ERROR_MESSAGE =
            "사다리 길이는 " + MIN_HEIGHT + "에서 " + MAX_HEIGHT + "사이여야 합니다.";

    private final LineGenerator lineGenerator;

    private int targetHeight;

    private int targetWidth;

    public LadderGenerator(final BooleanGenerator generator) {
        this.lineGenerator = new LineGenerator(generator);
    }

    public Ladder build(final int targetHeight, final int targetWidth) {
        setUp(targetHeight, targetWidth);
        return new Ladder(buildLines());
    }

    private void setUp(final int targetHeight, final int targetWidth) {
        validateLadderHeight(targetHeight);
        this.targetHeight = targetHeight;
        this.targetWidth = targetWidth;
    }

    private List<Line> buildLines() {
        final List<Line> lines = new ArrayList<>();

        for (int currentHeight = 0; currentHeight < targetHeight; currentHeight++) {
            lines.add(lineGenerator.build(targetWidth));
        }

        return lines;
    }

    private static void validateLadderHeight(final int height) {
        if (height < MIN_HEIGHT || height > MAX_HEIGHT) {
            throw new IllegalArgumentException(INVALID_LADDER_HEIGHT_ERROR_MESSAGE);
        }
    }
}
