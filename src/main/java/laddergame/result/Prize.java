package laddergame.result;

import laddergame.vo.PrizeName;

public class Prize {
    private final PrizeName prizeName;

    public Prize(String prizeName) {
        this.prizeName = new PrizeName(prizeName);
    }

    public String getPrizeName() {
        return prizeName.getName();
    }
}
