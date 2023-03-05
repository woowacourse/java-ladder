package domain.ladder;

import java.util.ArrayList;
import java.util.List;
import util.BooleanGenerator;

public class LadderGenerator {
    public static final int MAX_HEIGHT = 10;
    public static final int MIN_HEIGHT = 2;
    public static final String INVALID_LADDER_HEIGHT_ERROR_MESSAGE =
            "사다리 길이는 " + MIN_HEIGHT + "에서 " + MAX_HEIGHT + "사이여야 합니다.";

    private LadderGenerator(){}

    public static Ladder build(final int targetHeight, final int targetWidth, final BooleanGenerator generator) {
        validateLadderHeight(targetHeight);
        return new Ladder(buildLines(targetHeight, targetWidth, generator));
    }

    private static List<Line> buildLines(final int targetHeight, final int targetWidth, final BooleanGenerator generator) {
        final List<Line> lines = new ArrayList<>();

        for (int currentHeight = 0; currentHeight < targetHeight; currentHeight++) {
            lines.add(LineGenerator.build(targetWidth, generator));
        }

        return lines;
    }

    private static void validateLadderHeight(final int height) {
        if (height < MIN_HEIGHT || height > MAX_HEIGHT) {
            throw new IllegalArgumentException(INVALID_LADDER_HEIGHT_ERROR_MESSAGE);
        }
    }
}
