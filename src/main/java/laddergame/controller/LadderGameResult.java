package laddergame.controller;

import java.util.Map;

public class LadderGameResult {
    private final Map<String, String> result;

    public LadderGameResult(Map<String, String> result) {
        this.result = result;
    }

    public String prize(String member) {
        if (!result.containsKey(member)) {
            throw new IllegalArgumentException("해당 이름은 존재하지 않습니다");
        }
        return result.get(member);
    }

    public Map<String, String> allPrizes() {
        return result;
    }
}
