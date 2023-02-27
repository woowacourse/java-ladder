package laddergame.domain;

import java.util.Collections;
import java.util.List;

public class GameResult {

    private final Players players;
    private final WinningPrizes winningPrizes;

    public GameResult(final Players players, final WinningPrizes winningPrizes) {
        this.players = players;
        this.winningPrizes = winningPrizes;
    }

    public String findPlayerPrize(final String player) {
        final int index = getPlayerNames()
                .indexOf(player);
        return winningPrizes.getIndexPrize(index).getWinningPrize();
    }

    public boolean isContain(final String command) {
        return getPlayerNames().contains(command);

    }

    private List<String> getPlayerNames() {
        return players.getPlayerName();
    }

    public List<Player> getGameResult() {
        return Collections.unmodifiableList(players.getPlayers());
    }

    public WinningPrizes getWinningPrizes() {
        return winningPrizes;
    }
}
