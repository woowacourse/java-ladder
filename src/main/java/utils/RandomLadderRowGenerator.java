package utils;

import domain.LadderRow;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomLadderRowGenerator implements LadderRowGenerator {

    private static final Random RANDOM = new Random();

    public LadderRow generate(final int userCount) {
        List<Boolean> lines = getLines(userCount);
        return new LadderRow(lines);
    }

    private List<Boolean> getLines(final int userCount) {
        List<Boolean> lines = new ArrayList<>();
        boolean previousBar = RANDOM.nextBoolean();
        lines.add(previousBar);
        for (int i = 0; i < userCount - 2; i++) {
            boolean nextBar = convertBoolean(previousBar);
            lines.add(nextBar);
            previousBar = nextBar;
        }
        return lines;
    }

    private boolean convertBoolean(final boolean comparedBoolean) {
        if (comparedBoolean) {
            return false;
        }
        return RANDOM.nextBoolean();
    }
}
