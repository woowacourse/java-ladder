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
        legs.add(legGenerateStrategy.generateLeg());
        for (int i = 1; i < legCount; i++) {
            decideLegExist(legGenerateStrategy, legs, i);
        }
        return legs;
    }


    private static void decideLegExist(LegGenerateStrategy legGenerateStrategy, List<Leg> legs, int legIndex) {
        if (legs.get(legIndex - 1).isConnected()) {
            legs.add(Leg.UN_CONNECTED);
            return;
        }
        legs.add(legGenerateStrategy.generateLeg());
    }

    public int moveToNextLeg(int index) {
        if (notFarRightIndex(index) && legs.get(index).isConnected()) {
            return index + 1;
        }
        if (notFarLeftIndex(index) && legs.get(index - 1).isConnected()) {
            return index - 1;
        }
        return index;
    }

    private boolean notFarRightIndex(int index) {
        return index < legs.size();
    }

    private boolean notFarLeftIndex(int index) {
        return index > 0;
    }

    public List<Leg> getLegs() {
        return List.copyOf(legs);
    }
}
