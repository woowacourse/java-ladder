package domain.result;

import domain.player.Name;
import domain.player.Player;
import domain.player.Players;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Result {

    private static final String NO_SUCH_PLAYER_MESSAGE = "란, 플레이어는 없습니다.";

    private final HashMap<Player, Prize> result;

    public Result(final Players players, final Prizes prizes) {
        this.result = createResult(players, prizes);
    }

    private HashMap<Player, Prize> createResult(final Players players, final Prizes prizes) {
        HashMap<Player, Prize> result = new HashMap<>();
        List<Player> gamePlayers = players.getPlayers();

        for (int currentPlayerIndex = 0; currentPlayerIndex < gamePlayers.size(); currentPlayerIndex++) {
            Player currentPlayer = gamePlayers.get(currentPlayerIndex);
            result.put(currentPlayer, prizes.query(currentPlayer.getPosition()));
        }

        return result;
    }

    public String queryByPlayer(final String player) {
        Prize prize = result.get(new Player(new Name(player)));

        if (prize == null) {
            throw new IllegalArgumentException(player.toString() + NO_SUCH_PLAYER_MESSAGE);
        }

        return prize.toString();
    }

    @Override
    public String toString() {
        return result.entrySet().stream()
                .map(entry -> entry.getKey().toString() + " : " + entry.getValue().toString())
                .collect(Collectors.joining("\n"));
    }
}
