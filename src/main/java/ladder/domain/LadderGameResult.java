package ladder.domain;

import java.util.Map;

public class LadderGameResult {

    private Map<Player, String> nameToPrize;

    public LadderGameResult(Map<Player, String> nameToPrize) {
        this.nameToPrize = nameToPrize;
    }

    public Map<Player, String> getNameToPrize() {
        return this.nameToPrize;
    }
}
