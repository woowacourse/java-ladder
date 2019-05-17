package ladder.domain;

import java.util.Map;

public class LadderGameResult {

    private Map<Player, Prize> nameToPrize;

    public LadderGameResult(Map<Player, Prize> nameToPrize) {
        this.nameToPrize = nameToPrize;
    }

    public Map<Player, Prize> getNameToPrize() {
        return this.nameToPrize;
    }
}
