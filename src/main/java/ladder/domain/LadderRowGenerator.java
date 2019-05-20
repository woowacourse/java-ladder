package ladder.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LadderRowGenerator {
    private static final int LAST_LINE = 1;
    private static final int RANDOM_DRAW_NUMBER = 1;

    public static LadderRow row(int width) {
        List<LadderLine> lines = new ArrayList<>();
        return random(width, lines);
    }

    public static LadderRow row(List<LadderLine> directions) {
        return new LadderRow(directions);
    }

    private static LadderRow random(int width, List<LadderLine> lines) {
        while (width - lines.size() > LAST_LINE) {
            lines.addAll(draw(getRandomFlag()));
        }
        if (width - lines.size() == LAST_LINE) {
            lines.addAll(draw(false));
        }
        return new LadderRow(lines);
    }

    private static List<LadderLine> draw(boolean isDraw) {
        if (isDraw) {
            return Arrays.asList(new LadderLine(Direction.RIGHT), new LadderLine(Direction.LEFT));
        }
        return Arrays.asList(new LadderLine(Direction.SKIP));
    }

    private static boolean getRandomFlag() {
        return RandomGenerator.number() == RANDOM_DRAW_NUMBER;
    }
}
