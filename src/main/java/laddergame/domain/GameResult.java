package laddergame.domain;

import java.util.*;

public class GameResult {
    private final Map<Player, Prize> results;

    public GameResult(final PlayerResult playerResult, final PrizeGroup prizeGroup) {
        results = new HashMap<>();

        makeResult(playerResult, prizeGroup);
    }

    private void makeResult(final PlayerResult playerResult, final PrizeGroup prizeGroup) {
        List<Player> players = playerResult.getPlayers();
        List<Prize> prizes = prizeGroup.getPrizes();

        for (int i = 0; i < players.size(); i++) {
            results.put(players.get(i), prizes.get(i));
        }
    }

    public Prize getRequestedPrize(Player player) {
        validateExistedInputException(results.get(player));

        return results.get(player);
    }

    public Map<Player, Prize> getAllResult() {
        return results;
    }

    private static void validateExistedInputException(Prize prize) {
        if (Objects.isNull(prize)) {
            throw new IllegalArgumentException("일치하는 플레이어의 이름이 존재하지 않습니다.");
        }
    }
}
