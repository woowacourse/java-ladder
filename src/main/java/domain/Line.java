package domain;

import java.util.ArrayList;
import java.util.List;
import util.RandomGenerator;

public class Line {

    private final List<Leg> legs;

    public Line() {
        legs = new ArrayList<>();
    }

    public void makeLeg(int legCount) {
        legs.add(Leg.from(generateLegRandomly()));
        for (int i = 1; i < legCount; i++) {
            decideLegExist(i);
        }
    }

    private void decideLegExist(int legIndex) {
        if (legs.get(legIndex - 1).isExist()) {
            legs.add(Leg.from(false));
            return;
        }
        legs.add(Leg.from(true));
    }

    protected boolean generateLegRandomly() {
        return RandomGenerator.generateRandomBoolean();
    }

    public List<Leg> getLegs() {
        return List.copyOf(legs);
    }
}
