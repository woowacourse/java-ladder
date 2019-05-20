package ladder.model;

import ladder.model.objectname.LadderGoalName;
import ladder.model.objectname.LadderPlayerName;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static java.util.stream.Collectors.joining;

public class LadderLine {
    private static final String PIPE = "|";
    private static final String HYPHEN = "-";
    private static final String BLANK = " ";
    private static final boolean START_VALUE_FOR_GENERATING_CROSSBAR = false;
    private final List<Boolean> crossbars;

    public LadderLine(final List<Boolean> crossbars) {
        this.crossbars = crossbars;
    }

    public LadderLine(int width) {
        List<Boolean> createdCrossbars = new ArrayList<>();
        boolean crossbar = START_VALUE_FOR_GENERATING_CROSSBAR;
        for (int i = 0; i < width; i++) {
            crossbar = generateNextCrossbarByRandom(crossbar);
            createdCrossbars.add(crossbar);
        }
        this.crossbars = createdCrossbars;
    }

    private boolean generateNextCrossbarByRandom(boolean lastCrossbar) {
        return !lastCrossbar && new Random().nextBoolean();
    }

    boolean hasCrossbar(int column) {
        return crossbars.get(column);
    }

    private String createCrossbar(String mark) {
        StringBuilder stringBuilder = new StringBuilder();
        int maxLenOfAllNames
                = Math.max(LadderPlayerName.MAX_LENGTH_OF_PLAYER_NAME, LadderGoalName.MAX_LENGTH_OF_GOAL_NAME);
        for (int i = 0; i < maxLenOfAllNames; i++) {
            stringBuilder.append(mark);
        }
        return stringBuilder.toString();
    }

    @Override
    public String toString() {
        String crossbar = createCrossbar(HYPHEN);
        String emptySpace = createCrossbar(BLANK);

        return PIPE + crossbars.stream()
                .map(index -> index ? crossbar : emptySpace)
                .collect(joining(PIPE)) + PIPE;
    }
}
