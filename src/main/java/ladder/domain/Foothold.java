package ladder.domain;

import java.util.Arrays;

public enum Foothold {
    Y(true, "-----"), N(false, "     ");

    private final boolean state;
    private final String mark;

    Foothold(boolean state, String mark) {
        this.state = state;
        this.mark = mark;
    }

    public static Foothold from(boolean state) {
        return Arrays.stream(Foothold.values())
                .filter((foothold) -> foothold.state == state)
                .findAny()
                .get();
    }

    public String getMark() {
        return mark;
    }
}
