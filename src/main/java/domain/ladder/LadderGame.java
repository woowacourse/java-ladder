package domain.ladder;

import domain.player.Player;
import domain.player.Players;
import domain.result.Prizes;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LadderGame {

    private final Players players;
    private final Prizes prizes;
    private final Ladder ladder;

    public LadderGame(Players players, Prizes prizes, Ladder ladder) {
        validateSize(players, prizes);
        this.players = players;
        this.prizes = prizes;
        this.ladder = ladder;
    }

    public Map<String, String> start() {
        Map<String, String> gameResult = new HashMap<>();

        for (Player player : players.getPlayers()) {
            ladder.movePosition(player);

            addPlayerResult(gameResult, player);
        }
        return gameResult;
    }

    private void addPlayerResult(Map<String, String> gameResult, Player player) {
        String playerName = player.getName();
        String playerPrize = prizes.findByIndex(player.getPosition().getValue());
        gameResult.put(playerName, playerPrize);
    }

    private void validateSize(Players players, Prizes prizes) {
        if (players.getSize() != prizes.getPrizes().size()) {
            throw new IllegalArgumentException("참가자 수와 결과 수는 일치해야 합니다.");
        }
    }

    public List<Player> getPlayers() {
        return Collections.unmodifiableList(players.getPlayers());
    }

    public List<String> getPrizes() {
        return Collections.unmodifiableList(prizes.getPrizes());
    }

    public List<Line> getLadder() {
        return Collections.unmodifiableList(ladder.getLines());
    }
}
