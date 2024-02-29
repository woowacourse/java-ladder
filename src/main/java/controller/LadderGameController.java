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
        retryOnException(() -> provideLadderPlayOutcomeUntilEnd(ladderPlayOutcome));
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

    private Ladder makeLadder(LadderHeight ladderHeight, Players players, Prizes prizes) {
        Ladder ladder = Ladder.of(ladderHeight, players, new RandomBridgesGenerator());
        OutputView.printLadderIntro();
        OutputView.printPlayerNames(players);
        OutputView.printLadder(ladder);
        OutputView.printPrizeNames(prizes);
        return ladder;
    }

    private void provideLadderPlayOutcomeUntilEnd(LadderPlayOutcome ladderPlayOutcome) {
        boolean isContinue = true;
        while (isContinue) {
            isContinue = provideLadderPlayOutcome(ladderPlayOutcome);
        }
    }

    private boolean provideLadderPlayOutcome(LadderPlayOutcome ladderPlayOutcome) {
        String target = InputView.askTarget();
        OutputView.printLadderPlayOutcomeIntro();
        if (target.equals(END_CONDITION)) {
            showPrizeForAllPlayers(ladderPlayOutcome);
            return false;
        }
        showPrizeForOnePlayer(ladderPlayOutcome, target);
        return true;
    }

    private void showPrizeForAllPlayers(LadderPlayOutcome ladderPlayOutcome) {
        Map<Player, Prize> outcome = ladderPlayOutcome.getOutcome();
        OutputView.printPrizeForAllPlayers(outcome);
    }

    private void showPrizeForOnePlayer(LadderPlayOutcome ladderPlayOutcome, String target) {
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
