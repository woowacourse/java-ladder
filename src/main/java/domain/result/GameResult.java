package domain.result;

import domain.ladder.Ladder;
import domain.player.Player;
import domain.player.Players;
import domain.prize.Prize;
import domain.prize.Prizes;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class GameResult {
    private final Map<Player, Prize> playersPrize;

    private GameResult(final Map<Player, Prize> playersPrize) {
        this.playersPrize = playersPrize;
    }

    public static GameResult of(final Ladder ladder, final Players players, final Prizes prizes) {
        return new GameResult(createGameResult(ladder, players, prizes));
    }

    private static Map<Player, Prize> createGameResult(final Ladder ladder, final Players players,
                                                       final Prizes prizes) {
        Map<Player, Prize> playersWithPrize = new LinkedHashMap<>();

        for (int index = 0; players.isCountMoreThan(index); index++) {
            final int resultIndex = ladder.playLadder(index);
            final Player player = players.findByIndex(index);
            final Prize prize = prizes.findByIndex(resultIndex);

            playersWithPrize.put(player, prize);
        }
        return playersWithPrize;

    }

    public Prize search(final Player player) {
        return playersPrize.get(player);
    }

    public Map<Player, Prize> getPlayersPrize() {
        return Collections.unmodifiableMap(playersPrize);
    }
}
