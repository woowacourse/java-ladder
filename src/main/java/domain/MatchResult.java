package domain;

import constant.domain.MatchResultExceptionMessage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MatchResult {

    private final Map<Name, Prize> matchResult;

    public MatchResult(Participants participants, Result result, Ladder ladder) {
        matchResult = new HashMap<>();
        List<Player> players = participants.getPlayers();
        for (Player player : players) {
            ladder.findLastLocation(player);
            matchResult.put(player.getName(), result.getPrizeOf(player.getPosition()));
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
