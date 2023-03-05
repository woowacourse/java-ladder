package ladder.domain.ladder;

import java.util.Arrays;

public enum Bar {
    TRUE(true, "-----"),
    FALSE(false, "     ");

    private final boolean existBar;
    private final String barDisplay;

    Bar(boolean existBar, String barDisplay) {
        this.existBar = existBar;
        this.barDisplay = barDisplay;
    }

    public static Bar of(boolean existBar) {
        return Arrays.stream(Bar.values())
                .filter(bar -> bar.isMatch(existBar))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 값입니다."));
    }

    private boolean isMatch(boolean existBar) {
        return this.existBar == existBar;
    }

    public String getBarDisplay() {
        return this.barDisplay;
    }
}
