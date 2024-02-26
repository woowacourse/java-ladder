package domain;

import java.util.ArrayList;
import java.util.List;

public class Line {

    private final List<Leg> legs;

    private Line(List<Leg> legs) {
        this.legs = legs;
    }

    public static Line createLineWithLegs(LegGenerateStrategy legGenerateStrategy, int legCount) {
        List<Leg> legs = new ArrayList<>();
        legs.add(new Leg(legGenerateStrategy.generateLeg()));
        for (int i = 1; i < legCount; i++) {
            decideLegExist(legGenerateStrategy, legs, i);
        }
        return new Line(legs);
    }


    private static void decideLegExist(LegGenerateStrategy legGenerateStrategy, List<Leg> legs, int legIndex) {
        if (legs.get(legIndex - 1).isExistLeg()) {
            legs.add(new Leg(false));
            return;
        }
        legs.add(new Leg(legGenerateStrategy.generateLeg()));
    }

    public List<Leg> getLegs() {
        return List.copyOf(legs);
    }
}
