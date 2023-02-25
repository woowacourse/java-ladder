package ladder.domain;

import java.util.Arrays;

public enum Bar {
    TRUE(true),
    FALSE(false);
    
    private final boolean isExistBar;
    
    Bar(boolean isExistBar) {
        this.isExistBar = isExistBar;
    }
    
    public static Bar valueOfBar(boolean otherBar) {
        return Arrays.stream(values())
                .filter(bar -> bar.isSame(otherBar))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 Bar입니다."));
    }
    
    private boolean isSame(boolean otherBar) {
        return this.isExistBar == otherBar;
    }
    
    public boolean isExistBar(){
        return this.isExistBar;
    }
}
