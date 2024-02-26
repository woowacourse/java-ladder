package laddergame;

import java.util.function.BooleanSupplier;
import java.util.function.Supplier;
import laddergame.domain.Height;
import laddergame.domain.Ladder;
import laddergame.domain.Players;
import laddergame.domain.PlayersResults;
import laddergame.domain.Results;
import laddergame.domain.strategy.BuildStrategy;
import laddergame.domain.strategy.PointBuildStrategy;
import laddergame.util.ReservedWords;
import laddergame.view.InputView;
import laddergame.view.OutputView;

public class LadderGame {
    private final InputView inputView = InputView.getInstance();
    private final OutputView outputView = OutputView.getInstance();

    public void run() {
        final Players players = requestUntilValidated(() -> Players.from(inputView.readPlayersName()));
        final Results results = requestUntilValidated(
                () -> Results.from(inputView.readResultNames(), players.getPlayersSize()));
        final Height height = requestUntilValidated(() -> new Height(inputView.readLadderHeight()));
        final BuildStrategy pointBuildStrategy = new PointBuildStrategy();
        final Ladder ladder = new Ladder(players, height, results, pointBuildStrategy);
        outputView.writeLadderResult(players, ladder, results);
        final PlayersResults playersResults = ladder.getPlayersResults();
        repeatUntil(() -> runCommand(
                requestUntilValidated(() -> inputView.readDesiredPlayerName(players)), playersResults));
    }

    private boolean runCommand(final String name, final PlayersResults playersResults) {
        if (ReservedWords.isIncluded(name)) {
            outputView.writeAllResults(playersResults);
            return true;
        }
        outputView.writeDesiredResult(playersResults.find(name));
        return false;
    }

    private <T> T requestUntilValidated(Supplier<T> supplier) {
        try {
            return supplier.get();
        } catch (IllegalArgumentException e) {
            OutputView.writeErrorMessage(e.getMessage());
            return requestUntilValidated(supplier);
        }
    }

    private void repeatUntil(BooleanSupplier condition) {
        while (!condition.getAsBoolean()) {
        }
    }
}
