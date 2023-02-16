package model;

import java.util.Arrays;

public enum LadderStep {
    FIRST_STEP("first", String.format("%5s","    |")),
    EMPTY_STEP("empty", String.format("%6s","     |")),
    EXIST_STEP("exist", String.format("%6s","-----|"));

    private final String key;
    private final String step;

    LadderStep(String key, String step) {
        this.key = key;
        this.step = step;
    }

    public String getStep() {
        return step;
    }

    public static LadderStep of(String key) {
        return Arrays.stream(values())
                .filter(ladderStep -> ladderStep.key.equals(key))
                .findFirst()
                .orElseThrow(()-> new IllegalArgumentException("[ERROR] 존재하지 않는 LadderStep 입니다."));
    }
}
