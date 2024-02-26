package domain;

import java.util.ArrayList;
import java.util.List;

public class Line {

    private final List<Boolean> legs;

    private Line(List<Boolean> legs) {
        this.legs = legs;
    }

    public static Line createLineWithLegs(LegGenerateStrategy legGenerateStrategy, int legCount) {
        List<Boolean> legs = new ArrayList<>();
        legs.add(legGenerateStrategy.generateLeg());
        for (int i = 1; i < legCount; i++) {
            decideLegExist(legGenerateStrategy, legs, i);
        }
        return new Line(legs);
    }


    private static void decideLegExist(LegGenerateStrategy legGenerateStrategy, List<Boolean> legs, int legIndex) {
        if (legs.get(legIndex - 1)) {
            legs.add(false);
            return;
        }
        legs.add(legGenerateStrategy.generateLeg());
    }

    public List<Boolean> getLegs() {
        return List.copyOf(legs);
    }
}
