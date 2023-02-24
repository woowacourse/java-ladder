package domain.ladder;

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

    public boolean exists() {
        return this == EXISTS;
    }
}
