package ladder.view;

import ladder.domain.Bar;

import java.util.Arrays;

public enum BarDisplayMatcher {
    TRUE(true, "-----"),
    FALSE(false, "     ");
    
    private final boolean isExistBar;
    private final String barDisplay;

    BarDisplayMatcher(boolean isExistBar, String barDisplay) {
        this.isExistBar = isExistBar;
        this.barDisplay = barDisplay;
    }

    public static BarDisplayMatcher valueOfBarMatcher(Bar bar) {
        return Arrays.stream(values())
                .filter(barDisplayMatcher -> barDisplayMatcher.isSameBar(bar))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 값입니다."));
    }

    private boolean isSameBar(Bar bar) {
        return this.isExistBar == bar.isExistBar();
    }

    public String getBarDisplay() {
        return this.barDisplay;
    }
}
