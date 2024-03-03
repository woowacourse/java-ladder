package model;

import exception.Message;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

//TODO: result 대신 다른 이름 고민해보기
public record LadderResult(Map<String, String> playersPrizeResults) {

    private static final String CMD_ALL_RESULT = "all";

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

    public boolean isCmdAllResult(String cmd) {
        return CMD_ALL_RESULT.equals(cmd);
    }

    public String getPrize(final String name) {
        if (!playersPrizeResults.containsKey(name)) {
            throw new IllegalArgumentException(Message.INVALID_PLAYER_NAME_ERROR.getValue());
        }
        return playersPrizeResults.get(name);
    }
}
