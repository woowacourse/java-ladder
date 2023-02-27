package laddergame.result;

import laddergame.vo.PlayerName;

public class Prize {
    private final PlayerName name;

    public Prize(PlayerName name) {
        this.name = name;
    }

    public String getName() {
        return name.getName();
    }
}
