package domain;

import util.generator.BooleanGenerator;

import java.util.ArrayList;
import java.util.List;

public class Line {

    private final List<Leg> legs;

    private Line() {
        legs = new ArrayList<>();
    }

    public static Line of(int legCount, BooleanGenerator booleanGenerator) {
        Line line = new Line();
        line.makeLeg(legCount, booleanGenerator);
        return line;
    }

    private void makeLeg(int legCount, BooleanGenerator booleanGenerator) {
        legs.add(Leg.from(booleanGenerator.generate()));
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

    public List<Leg> getLegs() {
        return List.copyOf(legs);
    }
}
