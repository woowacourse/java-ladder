package model;

import exception.Message;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public record LadderResultDto(Map<String, String> playersPrizeResults) {

    public static LadderResultDto of(List<String> playerNames, List<String> prizes) {
        validate(playerNames, prizes);
        Map<String, String> result = new LinkedHashMap<>();
        for (int i = 0; i < playerNames.size(); i++) {
            result.put(playerNames.get(i), prizes.get(i));
        }
        return new LadderResultDto(result);
    }

    private static void validate(final List<String> playerNames, final List<String> prizes) {
        if (playerNames.size() != prizes.size()) {
            throw new IllegalStateException(Message.INVALID_PLAYERS_AND_PRIZES_SIZE.getMessage());
        }
    }

    public String getPrize(String name) {
        if (!playersPrizeResults.containsKey(name)) {
            throw new IllegalArgumentException(Message.INVALID_PLAYER_NAME_ERROR.getMessage());
        }
        return playersPrizeResults.get(name);
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LadderResultDto ladderResultDto)) {
            return false;
        }
        return Objects.equals(playersPrizeResults, ladderResultDto.playersPrizeResults);
    }
}
