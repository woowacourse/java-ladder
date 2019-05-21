package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class RandomCrossbarGenerator implements CrossbarGenerator {
    private static final int LAST_DUMMY_SPACE = 1;
    private static final int DUMMY_SIZE = 2;
    private static final boolean DUMMY_CROSSBAR = false;
    private static final Double RATE_OF_EMPTY_CROSSBAR = 0.5;

    private int numberOfCrossbar;

    public RandomCrossbarGenerator(int numberOfPlayer) {
        this.numberOfCrossbar = numberOfPlayer + LAST_DUMMY_SPACE;
    }

    @Override
    public Crosspoints generateCrossbars() {
        List<Boolean> crossbars = new ArrayList<>();
        setCrossbars(crossbars);
        return new Crosspoints(new Crossbar(crossbars));
    }

    private void setCrossbars(List<Boolean> crossbars) {
        crossbars.add(DUMMY_CROSSBAR);
        addRandomCrossbars(crossbars);
        crossbars.add(DUMMY_CROSSBAR);
    }

    private void addRandomCrossbars(List<Boolean> crossbars) {
        boolean lastAdded = false;

        while (crossbars.size() <= (numberOfCrossbar - DUMMY_SIZE)) {
            boolean bool = generateRandomBoolean();
            lastAdded = bool && !lastAdded;
            crossbars.add(lastAdded);
        }
    }

    private boolean generateRandomBoolean() {
        return Math.random() > RATE_OF_EMPTY_CROSSBAR;
    }
}
