package ladder.domain;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
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
        validateSize(players, ladder, prizes);

        Map<Player, Prize> results = new LinkedHashMap<>();

        for (int i = 0; i < players.size(); i++) {
            Player player = players.getPlayers().get(i);
            int endIndex = ladder.findEndIndex(i);
            Prize prize = prizes.getPrizes().get(endIndex);

            results.put(player, prize);
        }

        return new LadderGame(results);
    }

    private static void validateSize(Players players, Ladder ladder, Prizes prizes) {
        if (players.size() != ladder.getColumnSize() + 1) {
            throw new IllegalArgumentException("참가자 수와 사다리의 출발 지점 수가 일치하지 않습니다.");
        }

        if (prizes.size() != ladder.getColumnSize() + 1) {
            throw new IllegalArgumentException("상품 수와 사다리의 도착 지점 수가 일치하지 않습니다.");
        }
    }

    public Prize getResultByPlayerName(String playerName) {
        Player player = new Player(playerName);

        if (!results.containsKey(player)) {
            throw new IllegalArgumentException("존재하지 않는 참가자입니다.");
        }

        return results.get(player);
    }

    public Map<Player, Prize> getAllResults() {
        return Collections.unmodifiableMap(results);
    }
}
