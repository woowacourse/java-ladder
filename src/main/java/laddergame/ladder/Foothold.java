package laddergame.ladder;

import java.util.Arrays;

public enum Foothold {
    PASSABLE(true, "-----"),
    BLOCKED(false, "     "),
    ;

    private final boolean state;
    private final String format;

    Foothold(boolean state, String format) {
        this.state = state;
        this.format = format;
    }

    public static Foothold from(boolean state) {
        return Arrays.stream(Foothold.values())
                     .filter((foothold) -> foothold.state == state)
                     .findAny()
                     .orElseThrow(() -> new IllegalArgumentException("잘못된 발판 인자"));
    }

    public String getFormat() {
        return format;
    }
}
