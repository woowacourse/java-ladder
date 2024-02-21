package controller;

import java.util.List;
import java.util.function.Supplier;
import model.Ladder;
import model.LadderHeight;
import model.Players;
import model.RandomBridgesGenerator;
import view.InputView;
import view.OutputView;

public class LadderGameController {
    public void run() {
        Players players = retryOnException(this::preparePlayers);
        LadderHeight ladderHeight = retryOnException(this::prepareLadderHeight);
        Ladder ladder = makeLadder(players, ladderHeight);
        end(players, ladder);
    }

    private Players preparePlayers() {
        List<String> playerNames = InputView.askPlayerNames();
        return Players.create(playerNames);
    }

    private LadderHeight prepareLadderHeight() {
        int ladderHeight = InputView.askLadderHeight();
        return new LadderHeight(ladderHeight);
    }

    public Ladder makeLadder(Players players, LadderHeight ladderHeight) {
        return Ladder.create(ladderHeight, players, new RandomBridgesGenerator());
    }

    public void end(Players players, Ladder ladder) {
        OutputView.printGameResultIntro();
        OutputView.printPlayerNames(players);
        OutputView.printLadder(ladder);
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
