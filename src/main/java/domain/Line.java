package domain;

import java.util.ArrayList;
import java.util.List;

public class Line {

    private final List<Leg> legs;

    public Line(LegGenerateStrategy legGenerateStrategy, int legCount) {
        this.legs = makeLegs(legGenerateStrategy, legCount);
    }

    private List<Leg> makeLegs(LegGenerateStrategy legGenerateStrategy, int legCount) {
        List<Leg> legs = new ArrayList<>();
        legs.add(new Leg(legGenerateStrategy.generateLeg()));
        for (int i = 1; i < legCount; i++) {
            decideLegExist(legGenerateStrategy, legs, i);
        }
        return legs;
    }


    private static void decideLegExist(LegGenerateStrategy legGenerateStrategy, List<Leg> legs, int legIndex) {
        if (legs.get(legIndex - 1).isExistLeg()) {
            legs.add(new Leg(false));
            return;
        }
        legs.add(new Leg(legGenerateStrategy.generateLeg()));
    }

    public int moveToNextIndex(int index) {
        if (index < legs.size() && legs.get(index).isExistLeg()) {
            return index + 1;
        }
        if (index > 0 && legs.get(index - 1).isExistLeg()) {
            return index - 1;
        }
        return index;
    }

    public List<Leg> getLegs() {
        return List.copyOf(legs);
    }
}
