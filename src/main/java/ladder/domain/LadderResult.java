package ladder.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class LadderResult {
    private final Map<String, String> result;

    public LadderResult(Map<String, String> result) {
        this.result = new HashMap<>(result);
    }

    public String findWinningItemNameByPersonName(String personName) {
        if (!result.containsKey(personName)) {
            throw new IllegalArgumentException("존재하지 않는 사람의 이름입니다.");
        }

        return result.get(personName);
    }

    public Map<String, String> getTotalResult() {
        return result.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }
}
