package model.ladder;

import java.util.Arrays;

public enum Step {
    EXIST(true),
    EMPTY(false);

    private final boolean doesExist;

    Step(boolean doesExist) {
        this.doesExist = doesExist;
    }

    public static Step findByExistence(boolean doesExist) {
        return Arrays.stream(values())
                .filter(value -> value.doesExist == doesExist)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("발판의 존재여부는 true, false 중 하나입니다."));
    }
}
