package domain;

import util.generator.BooleanGenerator;

import java.util.ArrayList;
import java.util.List;

import static message.ErrorMessage.OVERLAPPED_LINE_EXCEPTION;

public class Line {

    private final List<Leg> legs;

    private Line(int legCount, BooleanGenerator booleanGenerator) {
        legs = makeLegs(legCount,booleanGenerator);
    }

    public static Line of(int legCount, BooleanGenerator booleanGenerator) {
        return new Line(legCount, booleanGenerator);
    }

    private List<Leg> makeLegs(int legCount, BooleanGenerator booleanGenerator) {
        List<Leg> newLegs = new ArrayList<>();

        newLegs.add(Leg.from(booleanGenerator.generate()));
        for (int i = 1; i < legCount; i++) {
            decideLegExist(newLegs, i, booleanGenerator);
        }
        validateLegsUnOverlapped(newLegs);

        return newLegs;
    }

    private void decideLegExist(List<Leg> newLegs, int legIndex, BooleanGenerator booleanGenerator) {
        if (newLegs.get(legIndex - 1).isExist()) {
            newLegs.add(Leg.from(false));
            return;
        }
        newLegs.add(Leg.from(booleanGenerator.generate()));
    }

    private void validateLegsUnOverlapped(List<Leg> newLegs) {
        Leg beforeLeg = Leg.from(false);
        for (Leg afterLeg : newLegs) {
            validateLegUnOverlapped(afterLeg, beforeLeg);
        }
    }

    private void validateLegUnOverlapped(Leg beforeLeg, Leg afterLeg) {
        if (beforeLeg.isExist() && afterLeg.isExist()) {
            throw new IllegalArgumentException(OVERLAPPED_LINE_EXCEPTION.getMessage());
        }
    }

    public List<Leg> getLegs() {
        return List.copyOf(legs);
    }
}
