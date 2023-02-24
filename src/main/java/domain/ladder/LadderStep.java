package domain.ladder;

import domain.generator.BooleanGenerator;
import java.util.Arrays;
import java.util.NoSuchElementException;

public enum LadderStep {
    EXISTS(true), NONE(false);

    private final boolean isExist;

    LadderStep(boolean isExist) {
        this.isExist = isExist;
    }

    public static LadderStep from(boolean isExist) {
        return Arrays.stream(LadderStep.values())
                .filter(ladderStep -> ladderStep.isExist == isExist)
                .findFirst()
                .orElseThrow(NoSuchElementException::new);
    }

    public static LadderStep of(LadderStep previousStep, BooleanGenerator generator) {
        if (previousStep.equals(EXISTS)) {
            return NONE;
        }
        return LadderStep.from(generator.generate());
    }

    public boolean exists() {
        return this.equals(EXISTS);
    }
}
