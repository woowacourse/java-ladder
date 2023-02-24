package domain.ladder;

import domain.generator.BooleanGenerator;

public enum LadderStep {
    EXISTS, NONE;

    public static LadderStep from(boolean isExist) {
        if (isExist) {
            return EXISTS;
        }
        return NONE;
    }

    public static LadderStep by(BooleanGenerator ladderGenerator) {
        if (ladderGenerator.generate()) {
            return EXISTS;
        }
        return NONE;
    }

    public static LadderStep of(LadderStep previousStep, BooleanGenerator generator) {
        if (previousStep.equals(EXISTS)) {
            return NONE;
        }
        return LadderStep.by(generator);
    }

    public boolean exists() {
        return this.equals(EXISTS);
    }
}
