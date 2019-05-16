package ladder.domain;

import java.util.Map;

public class LadderGameResult {

    private Map<String, String> nameToPrize;

    public LadderGameResult(Map<String, String> nameToPrize) {
        this.nameToPrize = nameToPrize;
    }

    public Map getNameToPrize() {
        return this.nameToPrize;
    }
}
