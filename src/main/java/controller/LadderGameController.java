package controller;

import java.util.List;
import java.util.function.Supplier;
import model.bridge.RandomBridgesGenerator;
import model.ladder.Ladder;
import model.ladder.LadderHeight;
import model.player.Players;
import view.InputView;
import view.OutputView;

public class LadderGameController {
    public void run() {
        Players players = retryOnException(this::preparePlayers);
        LadderHeight ladderHeight = retryOnException(this::prepareLadderHeight);
        Ladder ladder = Ladder.create(ladderHeight, players, new RandomBridgesGenerator());
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
