package laddergame.domain.ladder;

import java.util.LinkedHashMap;
import java.util.Map;

public class LadderGameResult {

    private final Map<String, String> result;

    public LadderGameResult(Map<String, String> result) {
        this.result = result;
    }

    // TODO name 객체 사용 여부, result 원시값 포장
    public String findByPlayerName(String name) {
        return result.get(name);
    }

    public Map<String, String> result() {
        return new LinkedHashMap<>(result);
    }
}
