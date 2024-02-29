package controller;

import java.util.List;
import java.util.function.Supplier;
import model.gameResult.GameResult;
import model.ladder.Ladder;
import model.ladder.LadderHeight;
import model.line.RandomLineGenerator;
import model.player.Players;
import model.prize.Prizes;
import view.InputView;
import view.OutputView;

public class LadderGameController {
    private static final String SEARCHING_END_CONDITION = "all";

    public void run() {
        Players players = preparePlayers();
        Prizes prizes = preparePrizes(players);
        LadderHeight ladderHeight = prepareLadderHeight();

        RandomLineGenerator randomLineGenerator = new RandomLineGenerator();
        Ladder ladder = Ladder.of(ladderHeight, players, randomLineGenerator);
        OutputView.printLadderResult(players, ladder, prizes);

        GameResult gameResult = ladder.simulate(players, prizes);
        searchGameResult(gameResult);
    }

    private Players preparePlayers() {
        return retryOnException(() -> {
            List<String> playerNames = InputView.askPlayerNames();
            return Players.of(playerNames);
        });
    }

    private Prizes preparePrizes(Players players) {
        return retryOnException(() -> {
            List<String> prizeNames = InputView.askPrizeNames();
            return Prizes.from(prizeNames, players);
        });
    }

    private LadderHeight prepareLadderHeight() {
        return retryOnException(() -> {
            int ladderHeight = InputView.askLadderHeight();
            return new LadderHeight(ladderHeight);
        });
    }

    private void searchGameResult(GameResult gameResult) {
        boolean continueSearching = true;
        while (continueSearching) {
            continueSearching = searchPrizeAndPrint(gameResult);
        }
    }

    private boolean searchPrizeAndPrint(GameResult gameResult) {
        return retryOnException(() -> {
            String playerName = InputView.askPlayerNameForSearching();
            OutputView.printSearchingResult(playerName, gameResult);
            return !playerName.equals(SEARCHING_END_CONDITION);
        });
    }

    private <T> T retryOnException(Supplier<T> retryOperation) {
        try {
            return retryOperation.get();
        } catch (IllegalArgumentException e) {
            OutputView.printExceptionMessage(e.getMessage());
            return retryOnException(retryOperation);
        }
    }
}
