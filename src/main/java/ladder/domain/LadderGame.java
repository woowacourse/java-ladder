package ladder.domain;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import ladder.domain.ladder.Ladder;
import ladder.domain.player.Player;
import ladder.domain.player.Players;

public class LadderGame {
    private final Map<Player, String> result = new LinkedHashMap<>();

    public LadderGame(Players players, Ladder ladder, Prizes prizes) {
        matchPlayersAndPrizes(players, ladder, prizes);
    }

    private void matchPlayersAndPrizes(Players players, Ladder ladder, Prizes prizes) {
        for (int i = 0; i < players.getSize(); i++) {
            int endIndex = ladder.findEndIndex(i);
            String prize = prizes.getPrizes().get(endIndex);

            result.put(players.getPlayers().get(i), prize);
        }
    }

    public String getResultByPlayerName(String playerName) {
        for (Entry<Player, String> entry : result.entrySet()) {
            if (entry.getKey().getName().equals(playerName)) {
                return entry.getValue();
            }
        }

        throw new IllegalArgumentException("존재하지 않는 참가자입니다.");
    }

    public Map<Player, String> getAllResult() {
        return Collections.unmodifiableMap(result);
    }
}
