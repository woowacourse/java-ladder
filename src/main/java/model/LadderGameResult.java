package model;

import exception.Message;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public record LadderGameResult(Map<String, String> playersPrizeResults) {

    public static LadderGameResult of(final List<String> playerNames, final List<String> prizes) {
        validate(playerNames, prizes);
        Map<String, String> result = new LinkedHashMap<>();
        for (int i = 0; i < playerNames.size(); i++) {
            result.put(playerNames.get(i), prizes.get(i));
        }
        return new LadderGameResult(result);
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
}
