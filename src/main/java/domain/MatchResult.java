package domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MatchResult {

    private final Map<Name, Prize> matchResult;

    public MatchResult(Participants participants, Result result, Ladder ladder) {
        matchResult = new HashMap<>();
        List<Name> names = participants.getNames();
        for (int indexOfName = 0; indexOfName < names.size(); indexOfName++) {
            Name name = names.get(indexOfName);
            int lastLocation = ladder.findLastLocation(indexOfName);
            Prize prize = result.getPrizeOf(lastLocation);
            matchResult.put(name, prize);
        }
    }

    public Prize getResultByName(Name name) {
        Prize result = matchResult.get(name);
        if (result == null) {
            throw new IllegalArgumentException("[ERROR] 존재하지 않는 사용자입니다.");
        }
        return matchResult.get(name);
    }

    public Map<Name, Prize> getResultAll() {
        return matchResult;
    }
}
