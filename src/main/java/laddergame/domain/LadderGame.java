package laddergame.domain;

import laddergame.domain.gameelements.*;
import laddergame.domain.ladder.Ladder;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

public class LadderGame {
    private final Ladder ladder;
    private final Prizes prizes;
    private final Map<Player, Prize> playerGameResult;
    private final Players players;

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
            Optional<Prize> prize = findPrizeByPosition(playerPosition);

            playerGameResult.put(player, prize.get());
        }
    }

    public Prize findPlayerResult(Name playerName) {
        Optional<Player> targetPlayer = findPlayerByName(playerName);

        if (targetPlayer.isPresent()) {
            return playerGameResult.get(targetPlayer.get());
        }

        throw new IllegalArgumentException("참여하지 않은 플레이어의 이름을 조회했습니다.");
    }

    private Optional<Prize> findPrizeByPosition(Position playerPosition) {
        return prizes.getPrizes()
                .stream()
                .filter(p -> p.getPosition().equals(playerPosition)).findFirst();
    }

    private Optional<Player> findPlayerByName(Name playerName) {
        return players.getPlayers()
                .stream()
                .filter(i -> i.getName() == playerName)
                .findFirst();
    }

    public Map<Player, Prize> getPlayerGameResult() {
        return playerGameResult;
    }
}
