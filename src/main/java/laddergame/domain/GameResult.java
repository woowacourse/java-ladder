package laddergame.domain;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class GameResult {

    private final List<Player> gameResult;
    private final WinningPrizes winningPrizes;

    public GameResult(final List<Player> gameResult, final WinningPrizes winningPrizes) {
        this.gameResult = gameResult;
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
        return gameResult.stream()
                .map(Player::getName)
                .collect(toList());
    }

    public List<Player> getGameResult() {
        return gameResult;
    }

    public WinningPrizes getWinningPrizes() {
        return winningPrizes;
    }
}
