package controller;

import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import model.bridge.RandomBridgesGenerator;
import model.ladder.Ladder;
import model.ladder.LadderHeight;
import model.ladder.LadderPlayOutcome;
import model.player.Player;
import model.player.Players;
import model.prize.Prize;
import model.prize.Prizes;
import view.InputView;
import view.OutputView;

public class LadderGameController {
    private static final String END_CONDITION = "all";

    public void run() {
        Players players = retryWithReturnOnException(this::preparePlayers);
        Prizes prizes = retryWithReturnOnException(() -> preparePrizes(players));
        LadderHeight ladderHeight = retryWithReturnOnException(this::prepareLadderHeight);
        Ladder ladder = makeLadder(ladderHeight, players, prizes);
        LadderPlayOutcome ladderPlayOutcome = ladder.play(players, prizes);
        retryOnException(() -> playLadderGameUntilEnd(ladderPlayOutcome));
    }

    private Players preparePlayers() {
        List<String> playerNames = InputView.askPlayerNames();
        return Players.from(playerNames);
    }

    private LadderHeight prepareLadderHeight() {
        int ladderHeight = InputView.askLadderHeight();
        return new LadderHeight(ladderHeight);
    }

    private Prizes preparePrizes(Players players) {
        List<String> prizeNames = InputView.askPrizeNames();
        return Prizes.of(players, prizeNames);
    }

    public Ladder makeLadder(LadderHeight ladderHeight, Players players, Prizes prizes) {
        Ladder ladder = Ladder.of(ladderHeight, players, new RandomBridgesGenerator());
        OutputView.printLadderIntro();
        OutputView.printPlayerNames(players);
        OutputView.printLadder(ladder);
        OutputView.printPrizeNames(prizes);
        return ladder;
    }

    public void playLadderGameUntilEnd(LadderPlayOutcome ladderPlayOutcome) {
        boolean isContinue = true;
        while (isContinue) {
            isContinue = playLadderGame(ladderPlayOutcome);
        }
    }

    private boolean playLadderGame(LadderPlayOutcome ladderPlayOutcome) {
        String target = InputView.askTarget();
        OutputView.printLadderPlayOutcomeIntro();
        if (target.equals(END_CONDITION)) {
            printPrizeForAllPlayers(ladderPlayOutcome);
            return false;
        }
        printPrizeForOnePlayer(ladderPlayOutcome, target);
        return true;
    }

    private void printPrizeForAllPlayers(LadderPlayOutcome ladderPlayOutcome) {
        Map<Player, Prize> outcome = ladderPlayOutcome.getOutcome();
        OutputView.printPrizeForAllPlayers(outcome);
    }

    private void printPrizeForOnePlayer(LadderPlayOutcome ladderPlayOutcome, String target) {
        Player player = new Player(target);
        Prize prize = ladderPlayOutcome.get(player);
        OutputView.printPrizeForOnePlayer(prize);
    }

    private <T> T retryWithReturnOnException(Supplier<T> retryOperation) {
        try {
            return retryOperation.get();
        } catch (IllegalArgumentException e) {
            OutputView.printExceptionMessage(e.getMessage());
            return retryWithReturnOnException(retryOperation);
        }
    }

    private void retryOnException(Runnable action) {
        try {
            action.run();
        } catch (IllegalArgumentException e) {
            OutputView.printExceptionMessage(e.getMessage());
            retryOnException(action);
        }
    }
}
