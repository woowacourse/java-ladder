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

        playerGameResult = new LinkedHashMap<>();
    }

    public void playGame() {
        ladder.getResult(players);

        for (Player player : players.getPlayers()) {
            Position playerPosition = player.getPlayerPosition();
            Prize prize = findPrizeByPosition(playerPosition);

            playerGameResult.put(player, prize);
        }
    }

    public Prize findPrizeByPlayerName(String playerName) {
        return playerGameResult.get(findPlayerByName(playerName));
    }


    private Prize findPrizeByPosition(Position playerPosition) {
        return prizes.getPrizes()
                .stream()
                .filter(prize -> prize.getPosition().isSame(playerPosition))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("찾는 위치의 Prize가 존재하지 않습니다."));
    }

    private Player findPlayerByName(String playerName) {
        return players.getPlayers()
                .stream()
                .filter(player -> player.getName().equals(playerName))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("참여하지 않은 플레이어의 이름을 조회했습니다."));
    }

    public Map<Player, Prize> getPlayerGameResult() {
        return playerGameResult;
    }
}
