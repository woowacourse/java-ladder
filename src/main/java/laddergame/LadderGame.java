package laddergame;

import laddergame.domain.Height;
import laddergame.domain.Ladder;
import laddergame.domain.Players;
import laddergame.domain.strategy.NonContinuousLineBuildStrategy;
import laddergame.view.InputView;
import laddergame.view.OutputView;

import java.util.function.Supplier;

public class LadderGame {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void run() {
        Players players = retryUntilValidated(() -> Players.from(inputView.readPlayersName()));
        Height height = retryUntilValidated(() -> new Height(inputView.readLadderHeight()));

        Ladder ladder = new Ladder(new NonContinuousLineBuildStrategy(), players, height);
        printLadderResult(players, ladder);
    }

    private void printLadderResult(final Players players, final Ladder ladder) {
        outputView.writeResultTitle();
        outputView.writePlayersName(players);
        outputView.writeLadder(ladder);
    }

    private <T> T retryUntilValidated(Supplier<T> supplier) {
        try {
            return supplier.get();
        } catch (IllegalArgumentException e) {
            OutputView.writeErrorMessage(e.getMessage());
            return retryUntilValidated(supplier);
        }
    }
}
