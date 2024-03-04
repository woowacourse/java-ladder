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

    // TODO 일관성 -> this를 붙이기
    public void playGame() {
        ladder.climb(players);

        for (Player player : players.getPlayers()) {
            Position playerPosition = player.getPlayerPosition();
            Prize prize = findPrizeByPosition(playerPosition);

            playerGameResult.put(player, prize);
        }
    }

    // TODO 린트 검사 -> 컨벤션
    public Prize findPrizeByPlayerName(String playerName) {
        if (playerGameResult.isEmpty()) {
            throw new IllegalStateException("아직 사다리 게임이 실행되지 않았습니다.");
        }

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
