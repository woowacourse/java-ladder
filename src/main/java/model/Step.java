package model;

import java.util.Arrays;

public enum Step {
    EXIST(true, "-----"),
    NONE(false, "     ");

    private final boolean step;
    private final String output;

    Step(boolean step, String output) {
        this.step = step;
        this.output = output;
    }

    public static Step valueOfStep(boolean step) {
        return Arrays.stream(values())
                .filter(value -> value.step == step)
                .findAny()
                .orElse(null);
    }

    public String getOutput() {
        return output;
    }
}
