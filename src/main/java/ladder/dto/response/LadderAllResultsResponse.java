package ladder.dto.response;

import java.util.LinkedHashMap;
import java.util.Map;
import ladder.domain.player.Player;
import ladder.domain.prize.Prize;

public record LadderAllResultsResponse(Map<String, String> allResults) {
    public static LadderAllResultsResponse from(Map<Player, Prize> allResults) {
        Map<String, String> allResultsResponse = new LinkedHashMap<>();

        for (Map.Entry<Player, Prize> entry : allResults.entrySet()) {
            String playerName = entry.getKey().name();
            String prizeName = entry.getValue().name();

            allResultsResponse.put(playerName, prizeName);
        }

        return new LadderAllResultsResponse(allResultsResponse);
    }
}
