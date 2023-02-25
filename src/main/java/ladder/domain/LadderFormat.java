package ladder.domain;

import java.util.Arrays;

public enum LadderFormat {
    FOOT_BAR(Boolean.TRUE, "-"),
    EMPTY(Boolean.FALSE, " ");

    private final Boolean condition;
    private final String component;

    LadderFormat(Boolean condition, String component) {
        this.condition = condition;
        this.component = component;
    }

    public static String getComponent(Boolean condition) {
        return Arrays.stream(values())
            .filter(format -> format.condition == condition)
            .findAny()
            .orElseThrow()
            .component;
    }
}
