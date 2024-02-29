package controller;

import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import model.bridge.RandomBridgesGenerator;
import model.ladder.Ladder;
import model.ladder.LadderHeight;
import model.ladder.LadderPlayOutcome;
import model.player.Players;
import model.prize.Prizes;
import view.InputView;
import view.OutputView;

public class LadderGameController {
    public void run() {
        Players players = retryOnException(this::preparePlayers);
        Prizes prizes = retryOnExceptionWithParameter(this::preparePrizes, players);
        LadderHeight ladderHeight = retryOnException(this::prepareLadderHeight);
        Ladder ladder = makeLadder(ladderHeight, players, prizes);
        playLadder(ladder, players, prizes);
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
        OutputView.printGameResultIntro();
        OutputView.printPlayerNames(players);
        OutputView.printLadder(ladder);
        OutputView.printPrizeNames(prizes);
        return ladder;
    }

    public void playLadder(Ladder ladder, Players players, Prizes prizes) {
        LadderPlayOutcome ladderPlayOutcome = ladder.play(players, prizes);
    }

    private <T> T retryOnException(Supplier<T> retryOperation) {
        try {
            return retryOperation.get();
        } catch (IllegalArgumentException e) {
            OutputView.printExceptionMessage(e.getMessage());
            return retryOnException(retryOperation);
        }
    }

    public static <T, R> R retryOnExceptionWithParameter(Function<T, R> retryOperation, T parameter) {
        try {
            return retryOperation.apply(parameter);
        } catch (IllegalArgumentException e) {
            OutputView.printExceptionMessage(e.getMessage());
            return retryOnExceptionWithParameter(retryOperation, parameter);
        }
    }
}
