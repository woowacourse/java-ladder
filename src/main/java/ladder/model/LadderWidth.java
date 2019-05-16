package ladder.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class LadderWidth {

    private static final String PIPE = "|";
    private static final String HYPHEN = "-";
    private static final String BLANK = " ";
    private static final boolean INITIAL_INDEX = false;

    private List<Boolean> crossbars;
    private int maxLenOfGoalNames;

    public LadderWidth(List<Boolean> crossbars) {
        this.crossbars = crossbars;
    }

    public LadderWidth(int width, int maxLenOfGoalNames) {
        this.crossbars = generateLadderWidth(width);
        this.maxLenOfGoalNames = maxLenOfGoalNames;
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

    private String createCrossbar(String mark){
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0 ; i < maxLenOfGoalNames ; i++){
            stringBuilder.append(mark);
        }
        return stringBuilder.toString();
    }

    @Override
    public String toString() {
        String crossbar = createCrossbar(HYPHEN);
        String notCrossbar = createCrossbar(BLANK);

        return PIPE + crossbars.stream().map(index -> {
            if (index) {
                return crossbar;
            }
            return notCrossbar;
        }).collect(Collectors.joining(PIPE)) + PIPE;
    }
}
