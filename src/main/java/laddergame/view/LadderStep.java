package laddergame.view;

import java.util.Arrays;

public enum LadderStep {
    FOOTSTEP(true, "-"),
    BLANK(false, " ");

    boolean isStep;
    String step;

    LadderStep(boolean isStep, String step) {
        this.isStep = isStep;
        this.step = step;
    }

    public static LadderStep valueOf(boolean isStep) {
        return Arrays.stream(LadderStep.values())
                .filter(e -> e.isStep == isStep)
                .findAny().orElseThrow(() -> new IllegalStateException("해당하는 값이 없습니다"));
    }

    public String getStep() {
        return step;
    }
}
