package ladder.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class LadderWidth {

    private static final String PIPE = "|";
    private static final boolean INITIAL_INDEX = false;
    private List<Boolean> crossbars;

    public LadderWidth(List<Boolean> crossbars) {
        this.crossbars = crossbars;
    }

    public LadderWidth(int width) {
        this.crossbars = generateLadderWidth(width);
    }

    private List<Boolean> generateLadderWidth(int width) {
        crossbars = new ArrayList<>();
        boolean index = INITIAL_INDEX;
        for (int i = 0; i < width; i++) {
            index = generateRandom(index);
            crossbars.add(index);
        }
        return crossbars;
    }

    private boolean generateRandom(boolean index) {
        return !index && new Random().nextBoolean();
    }

    @Override
    public String toString() {
        return PIPE + crossbars.stream().map(crossbar -> {
            if (crossbar) {
                return "-----";
            }
            return "     ";
        }).collect(Collectors.joining(PIPE)) + PIPE;
    }
}
