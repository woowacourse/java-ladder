package laddergame.domain;

import laddergame.domain.gameelements.*;
import laddergame.domain.ladder.Ladder;

import java.util.LinkedHashMap;
import java.util.Map;

public class LadderGame {
    private final Players players;
    private final Ladder ladder;
    private final Prizes prizes;
    private final Map<Player, Prize> playerGameResult;

    public LadderGame(Players players, Ladder ladder, Prizes prizes) {

        this.players = players;
        this.ladder = ladder;
        this.prizes = prizes;

        this.playerGameResult = new LinkedHashMap<>();
    }

    public void playGame() {
        ladder.climb(players);

        for (Player player : players.getPlayers()) {
            Position playerPosition = player.getPlayerPosition();
            Prize prize = prizes.findSamePositionPrize(playerPosition);

            this.playerGameResult.put(player, prize);
        }
    }

    public Prize findPrizeByPlayerName(String playerName) {
        if (playerGameResult.isEmpty()) {
            throw new IllegalStateException("아직 사다리 게임이 실행되지 않았습니다.");
        }

        Player targetPlayer = players.findPlayerByName(playerName);
        return playerGameResult.get(targetPlayer);
    }

    public Map<Player, Prize> getPlayerGameResult() {
        return playerGameResult;
    }
}
