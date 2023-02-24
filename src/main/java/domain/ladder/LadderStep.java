package domain.ladder;

import domain.generator.BooleanGenerator;

public enum LadderStep {
    EXISTS, NONE;

    public static LadderStep createFreely(BooleanGenerator ladderGenerator) {
        if (ladderGenerator.generate()) {
            return EXISTS;
        }
        return NONE;
    }

    public static LadderStep createConsideringPreviousStep(BooleanGenerator generator, LadderStep previousStep) {
        if (previousStep.equals(EXISTS)) {
            return NONE;
        }
        return LadderStep.createFreely(generator);
    }

    public boolean exists() {
        return this.equals(EXISTS);
    }
}
