package model;

import java.util.Arrays;

public enum Step {
    EXIST(true),
    NONE(false);

    private final boolean doesExist;

    Step(boolean doesExist) {
        this.doesExist = doesExist;
    }

    public static Step findByExistence(boolean doesExist) {
        return Arrays.stream(values())
                .filter(value -> value.doesExist == doesExist)
                .findAny()
                .orElse(null);
    }

    public boolean getDoesExist() {
        return doesExist;
    }
}
