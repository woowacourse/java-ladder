package utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import domain.LadderRow;

public class RandomLadderRowGenerator implements LadderRowGenerator{

    private static final Random RANDOM = new Random();

    public LadderRow generate(int userCount) {
        List<Boolean> lines = getLines(userCount);
        return new LadderRow(lines);
    }

    private List<Boolean> getLines(int userCount) {
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

    private boolean convertBoolean(boolean comparedBoolean) {
        if (comparedBoolean) {
            return false;
        }
        return RANDOM.nextBoolean();
    }
}
