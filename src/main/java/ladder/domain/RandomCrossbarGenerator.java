package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class RandomCrossbarGenerator implements CrossbarGenerator {
    private static final Double RATE_OF_EMPTY_CROSSBAR = 0.5;
    private static final int DUMMY_SIZE = 2;
    private static final boolean DUMMY_CROSSBAR = false;

    private int numberOfCrossbar;
    private List<Boolean> crossbars;

    RandomCrossbarGenerator(int numberOfCrossbar) {
        this.numberOfCrossbar = numberOfCrossbar;
    }

    @Override
    public Crossbars generateCrossbars() {
        setCrossbars();
        return new Crossbars(crossbars);
    }

    private void setCrossbars() {
        crossbars = new ArrayList<>();

        crossbars.add(DUMMY_CROSSBAR);
        addRandomCrossbars();
        crossbars.add(DUMMY_CROSSBAR);
    }

    private void addRandomCrossbars() {
        boolean lastAdded = false;

        while (crossbars.size() <= numberOfCrossbar - DUMMY_SIZE) {
            boolean bool = generateRandomBoolean();
            lastAdded = bool && !lastAdded;
            crossbars.add(lastAdded);
        }
    }

    private boolean generateRandomBoolean() {
        return Math.random() > RATE_OF_EMPTY_CROSSBAR;
    }
}
