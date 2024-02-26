package domain;

import util.generator.BooleanGenerator;

import java.util.ArrayList;
import java.util.List;

import static message.ErrorMessage.OVERLAPPED_LINE_EXCEPTION;

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
            decideLegExist(i, booleanGenerator);
        }
        validateLegsUnOverlapped();
    }

    private void decideLegExist(int legIndex, BooleanGenerator booleanGenerator) {
        if (legs.get(legIndex - 1).isExist()) {
            legs.add(Leg.from(false));
            return;
        }
        legs.add(Leg.from(booleanGenerator.generate()));
    }

    private void validateLegsUnOverlapped() {
        Leg beforeLeg = Leg.from(false);
        for (Leg afterLeg : legs) {
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
