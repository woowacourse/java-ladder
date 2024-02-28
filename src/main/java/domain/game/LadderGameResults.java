package domain.game;

import domain.ladder.Ladder;
import domain.player.Player;
import domain.player.Players;

import java.util.HashMap;
import java.util.Map;

public class LadderGameResults {
    private final Map<Player, GameResult> ladderGameResults;

    private LadderGameResults(final Map<Player, GameResult> ladderGameResults) {
        this.ladderGameResults = ladderGameResults;
    }

    public static LadderGameResults of(Ladder ladder, Players players, GameResults gameResults) {
        players.getPlayers()
                .forEach(player -> play(ladder, player));

        Map<Player, GameResult> ladderGameResults = new HashMap<>();
        players.getPlayers()
                .forEach(player -> ladderGameResults.put(player, gameResults.findGameResult(player.getCurrentLineNumber())));

        return new LadderGameResults(ladderGameResults);
    }

    private static void play(Ladder ladder, Player player) {
        while (!player.escapeLadder()) {
            ladder.movePlayer(player);
        }
    }
}
