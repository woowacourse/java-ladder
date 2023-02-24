package ladder.domain;

import java.util.LinkedHashMap;
import java.util.Map;

public class LadderGameResult {
    private static final String MULTIPLE_RESULT_RESERVED_NAME = "all";
    private static final String INVALID_PLAYER_MESSAGE = "사다리 게임에 참가한 사람의 이름을 입력해야합니다.";

    private final Map<String, String> result;

    public LadderGameResult(final Map<String, String> result) {
        this.result = result;
    }

    public Map<String, String> get(final String name) {
        if (MULTIPLE_RESULT_RESERVED_NAME.equals(name)) {
            return getMultipleResult();
        }
        return getSingleResult(name);
    }

    private Map<String, String> getMultipleResult() {
        return new LinkedHashMap<>(result);
    }

    private Map<String, String> getSingleResult(final String name) {
        if (!result.containsKey(name)) {
            throw new IllegalArgumentException(INVALID_PLAYER_MESSAGE);
        }
        return Map.of(name, result.get(name));
    }
}
