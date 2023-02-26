package domain.ladder;

import domain.generator.LadderStepGenerator;

public enum LadderStep {
    EXISTS, NONE;

    public static LadderStep createFreely(LadderStepGenerator ladderGenerator) {
        return ladderGenerator.generate();
    }

    public static LadderStep createConsideringPreviousStep(LadderStepGenerator generator, LadderStep previousStep) {
        if (previousStep.equals(EXISTS)) {
            return NONE;
        }
        return LadderStep.createFreely(generator);
    }

    public boolean exists() {
        return this.equals(EXISTS);
    }
}
