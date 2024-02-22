package domain;

import java.util.ArrayList;
import java.util.List;
import util.RandomGenerator;

public class Line {

    private final List<Boolean> legs;

    public Line() {
        legs = new ArrayList<>();
    }

    public void makeLeg(int legCount) {
        legs.add(generateLegRandomly());
        for (int i = 1; i < legCount; i++) {
            decideLegExist(i);
        }
    }

    private void decideLegExist(int legIndex) {
        if (legs.get(legIndex - 1)) {
            legs.add(false);
            return;
        }
        legs.add(generateLegRandomly());
    }

    protected boolean generateLegRandomly() {
        return RandomGenerator.generateRandomBoolean();
    }

    public List<Boolean> getLegs() {
        return List.copyOf(legs);
    }
}
