package domain.ladder;

import domain.player.Name;
import domain.prize.Prize;
import java.util.Collections;
import java.util.Map;

public class LadderResult {
    private static final String NOT_EXISTING_PLAYER_EXCEPTION_MESSAGE = "[ERROR] 잘못된 참가자명: %s - 존재하지 않는 참가자입니다.";

    private final Map<Name, Prize> results;

    public LadderResult(Map<Name, Prize> results) {
        this.results = results;
    }

    public Prize findPrizeByName(Name name) {
        if (!results.containsKey(name)) {
            throw new IllegalArgumentException(
                    String.format(NOT_EXISTING_PLAYER_EXCEPTION_MESSAGE, name.getValue())
            );
        }
        return results.get(name);
    }

    public Map<Name, Prize> getAllResults() {
        return Collections.unmodifiableMap(results);
    }
}
