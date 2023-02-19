package utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import domain.LadderRow;

public class RandomLadderRowGenerator implements LadderRowGenerator{

    private static final Random RANDOM = new Random();

    public LadderRow generate(int userCount) {
        List<Boolean> ladderRow = getBars(userCount);
        return new LadderRow(ladderRow);
    }

    private List<Boolean> getBars(int userCount) {
        List<Boolean> bars = new ArrayList<>();
        boolean previousBar = RANDOM.nextBoolean();
        bars.add(previousBar);
        for (int i = 0; i < userCount - 2; i++) {
            boolean nextBar = convertBoolean(previousBar);
            bars.add(nextBar);
            previousBar = nextBar;
        }
        return bars;
    }

    private boolean convertBoolean(boolean comparedBoolean) {
        if (comparedBoolean) {
            return false;
        }
        return RANDOM.nextBoolean();
    }
}
