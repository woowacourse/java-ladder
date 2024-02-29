package domain;

import constant.domain.MatchResultExceptionMessage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MatchResult {

    private final Map<Name, Prize> matchResult;

    public MatchResult(Participants participants, Result result, Ladder ladder) {
        matchResult = new HashMap<>();
        List<Name> names = participants.getNames();
        List<Prize> prizes = result.getPrizes();
        for (int indexOfName = 0; indexOfName < names.size(); indexOfName++) {
            Name name = names.get(indexOfName);
            int lastLocation = ladder.findLastLocation(indexOfName);
            Prize prize = prizes.get(lastLocation);
            matchResult.put(name, prize);
        }
    }

    public Prize getResultByName(Name name) {
        Prize result = matchResult.get(name);
        if (result == null) {
            throw new IllegalArgumentException(MatchResultExceptionMessage.NO_MATCHING_NAME.getExceptionMessage());
        }
        return matchResult.get(name);
    }

    public Map<Name, Prize> getResultAll() {
        return matchResult;
    }
}
