package ladder.view;

import java.util.Arrays;

public enum BarMatcher {
    TRUE(true, "-----"),
    FALSE(false, "     ");


    private final boolean isExistBar;
    private final String barDisplay;

    BarMatcher(boolean isExistBar, String barDisplay) {
        this.isExistBar = isExistBar;
        this.barDisplay = barDisplay;
    }

    public static BarMatcher valueOfBarMatcher(boolean isExistBar) {
        return Arrays.stream(values())
                .filter(barMatcher -> barMatcher.isSameBar(isExistBar))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 값입니다."));
    }

    private boolean isSameBar(boolean isExistBar) {
        return this.isExistBar == isExistBar;
    }

    public String getBarDisplay() {
        return this.barDisplay;
    }
}
