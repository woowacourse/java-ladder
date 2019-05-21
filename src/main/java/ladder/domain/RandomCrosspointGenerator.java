package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class RandomCrosspointGenerator implements CrosspointGenerator {
    private static final int FIRST_AND_LAST_SIZE = 2;
    private static final Double RATE_OF_EMPTY_CROSSBAR = 0.5;

    @Override
    public LadderRow generateLadderRow(int numberOfPlayer) {
        List<Crosspoint> ladderRow = new ArrayList<>();

        setRandomRow(numberOfPlayer, ladderRow);
        return new LadderRow(ladderRow);
    }

    private void setRandomRow(int numberOfPlayer, List<Crosspoint> ladderRow) {
        boolean prevBoolean = false;
        boolean nextBoolean = generateRandomBoolean(prevBoolean);
        ladderRow.add(Crosspoint.addFirst(nextBoolean));
        prevBoolean = nextBoolean;
        for (int i = 0; i < numberOfPlayer - FIRST_AND_LAST_SIZE; i++) {
            nextBoolean = generateRandomBoolean(prevBoolean);
            ladderRow.add(Crosspoint.addPoint(prevBoolean, nextBoolean));
            prevBoolean = nextBoolean;
        }
        ladderRow.add(Crosspoint.addLast(prevBoolean));
    }

    private boolean generateRandomBoolean(boolean prevBoolean) {
        if (prevBoolean) {
            return false;
        }
        return Math.random() > RATE_OF_EMPTY_CROSSBAR;
    }
}
