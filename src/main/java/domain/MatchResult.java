package domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MatchResult {

    private final Map<String, String> matchResult;

    public MatchResult(Participants participants, Result result, Ladder ladder) {
        matchResult = new HashMap<>();
        List<Name> names = participants.getNames();
        for (int indexOfName = 0; indexOfName < names.size(); indexOfName++) {
            Name name = participants.getNameOf(indexOfName);
            int lastLocation = ladder.findLastLocation(indexOfName);
            Prize prize = result.getPrizeOf(lastLocation);
            matchResult.put(name.getName(), prize.getPrize());
        }
    }

    public String getResultByName(String name) {
        String result = matchResult.get(name);
        if (result == null) {
            throw new IllegalArgumentException("[ERROR] 존재하지 않는 사용자입니다.");
        }
        return matchResult.get(name);
    }

    public Map<String, String> getResultAll() {
        return matchResult;
    }
}
