package ladder.domain;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import ladder.domain.ladder.Ladder;
import ladder.domain.player.Player;
import ladder.domain.player.Players;
import ladder.domain.prize.Prize;
import ladder.domain.prize.Prizes;

public class LadderGame {
    private final Map<Player, Prize> results;

    private LadderGame(Map<Player, Prize> results) {
        this.results = new LinkedHashMap<>(results);
    }

    public static LadderGame of(Players players, Ladder ladder, Prizes prizes) {
        Map<Player, Prize> results = new LinkedHashMap<>();

        for (int i = 0; i < players.size(); i++) {
            Player player = players.getPlayers().get(i);
            int endIndex = ladder.findEndIndex(i);
            Prize prize = prizes.getPrizes().get(endIndex);

            results.put(player, prize);
        }

        return new LadderGame(results);
    }

    public Prize getResultByPlayerName(String playerName) {
        for (Entry<Player, Prize> entry : results.entrySet()) {
            if (entry.getKey().name().equals(playerName)) {
                return entry.getValue();
            }
        }

        throw new IllegalArgumentException("존재하지 않는 참가자입니다.");
    }

    public Map<Player, Prize> getAllResults() {
        return Collections.unmodifiableMap(results);
    }
}
