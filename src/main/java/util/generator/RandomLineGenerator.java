package util.generator;

import domain.Leg;

import java.util.ArrayList;
import java.util.List;

import static message.ErrorMessage.OVERLAPPED_LINE_EXCEPTION;

public class RandomLineGenerator implements LineGenerator {

    private final BooleanGenerator booleanGenerator;

    public RandomLineGenerator() {
        this.booleanGenerator = new RandomBooleanGenerator();
    }

    @Override
    public List<Leg> generate(int legCount) {
        List<Leg> legs = new ArrayList<>();

        legs.add(Leg.from(booleanGenerator.generate()));
        for (int i = 1; i < legCount; i++) {
            decideLegExist(legs, i);
        }
        validateLegsUnOverlapped(legs);

        return legs;
    }

    private void decideLegExist(List<Leg> newLegs, int legIndex) {
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
}
