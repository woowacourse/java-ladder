package controller;

import java.util.List;
import java.util.function.Supplier;
import model.gameresult.GameResult;
import model.ladder.Ladder;
import model.ladder.LadderHeight;
import model.ladder.LadderResult;
import model.ladder.LadderWidth;
import model.ladder.RandomLadderGenerator;
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

        GameResult gameResult = executeGame(players, ladderHeight, prizes);
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

    private GameResult executeGame(Players players, LadderHeight ladderHeight, Prizes prizes) {
        LadderWidth ladderWidth = LadderWidth.from(players.getSize());
        Ladder ladder = RandomLadderGenerator.generateLadder(ladderHeight, ladderWidth);

        OutputView.printLadderResult(players, ladder, prizes);

        LadderResult ladderResult = LadderResult.from(ladder);
        return GameResult.of(ladderResult, players, prizes);
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
