package ladder.domain;

import java.util.Arrays;

public enum Step {
    Y(true, "-----"),
    N(false, "     ");

    private final boolean state;
    private final String mark;

    Step(boolean state, String mark) {
        this.state = state;
        this.mark = mark;
    }

    public static Step from(boolean state) {
        return Arrays.stream(Step.values())
                .filter((foothold) -> foothold.state == state)
                .findAny()
                .get();
    }

    public String getMark() {
        return mark;
    }
}
