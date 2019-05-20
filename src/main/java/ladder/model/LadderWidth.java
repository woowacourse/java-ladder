package ladder.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import static ladder.MessageCollection.*;

public class LadderWidth {

    private static final boolean INITIAL_INDEX = false;

    private List<Boolean> crossbars;
    private int maxLenOfGoalNames;

    // test 생성자
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

    public List<LadderPlayer> changePlayer(List<LadderPlayer> players) {
        for (int i = 0; i < crossbars.size(); i++) {
            if (crossbars.get(i)) {
                LadderPlayer temp = players.get(i);
                players.set(i, players.get(i + 1));
                players.set(i + 1, temp);
            }
        }
        return players;
    }

    private String createCrossbar(String mark) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < maxLenOfGoalNames; i++) {
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
