package domain.game;

import domain.ladder.Ladder;
import domain.player.Player;
import domain.player.Players;

import java.util.List;

import static java.util.Collections.unmodifiableList;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class LadderGameResults {
    private static final String ALL = "all";

    private final List<LadderGameResult> ladderGameResults;

    private LadderGameResults(final List<LadderGameResult> ladderGameResults) {
        this.ladderGameResults = ladderGameResults;
    }

    public static LadderGameResults of(final Ladder ladder, final Players players, final GameResults gameResults) {
        players.getPlayers()
                .forEach(player -> play(ladder, player));

        return players.getPlayers()
                .stream()
                .map(player -> new LadderGameResult(player.getPlayerName(), gameResults.findGameResult(player.getCurrentLineNumber())))
                .collect(collectingAndThen(toList(), LadderGameResults::new));
    }

    private static void play(final Ladder ladder, final Player player) {
        while (!player.isEscapeLadder()) {
            ladder.movePlayer(player);
        }
    }

    public List<LadderGameResult> findPlayerGameResults(final String playerName) {
        if (playerName.equals(ALL)) {
            return unmodifiableList(ladderGameResults);
        }

        return getPlayerLadderGameResult(playerName);
    }

    private List<LadderGameResult> getPlayerLadderGameResult(final String playerName) {
        LadderGameResult targetLadderGameResult = ladderGameResults.stream()
                .filter(ladderGameResult -> ladderGameResult.isPlayerName(playerName))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("유효하지 않은 사용자 이름입니다."));

        return List.of(targetLadderGameResult);
    }
}
