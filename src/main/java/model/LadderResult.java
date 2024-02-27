package model;

import exception.Message;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public final class LadderResult {
    private final Map<String, String> playersPrizeResults;

    public LadderResult(final Map<String, String> playersPrizeResults) {
        this.playersPrizeResults = playersPrizeResults;
    }

    public static LadderResult of(final List<String> playerNames, final List<String> prizes) {
        validate(playerNames, prizes);
        Map<String, String> result = new LinkedHashMap<>();
        for (int i = 0; i < playerNames.size(); i++) {
            result.put(playerNames.get(i), prizes.get(i));
        }
        return new LadderResult(result);
    }

    private static void validate(final List<String> playerNames, final List<String> prizes) {
        if (playerNames.size() != prizes.size()) {
            throw new IllegalStateException(Message.INVALID_PLAYERS_AND_PRIZES_SIZE.getValue());
        }
    }

    public String getPrize(final String name) {
        if (!playersPrizeResults.containsKey(name)) {
            throw new IllegalArgumentException(Message.INVALID_PLAYER_NAME_ERROR.getValue());
        }
        return playersPrizeResults.get(name);
    }

    public Map<String, String> getPlayersPrizeResults() {
        return playersPrizeResults;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LadderResult ladderResult)) {
            return false;
        }
        return Objects.equals(playersPrizeResults, ladderResult.playersPrizeResults);
    }

    @Override
    public int hashCode() {
        return Objects.hash(playersPrizeResults);
    }

    @Override
    public String toString() {
        return "LadderResult[" +
                "playersPrizeResults=" + playersPrizeResults + ']';
    }

}
