package laddergame;

import java.util.function.Supplier;
import laddergame.domain.Height;
import laddergame.domain.Ladder;
import laddergame.domain.Players;
import laddergame.domain.PlayersResults;
import laddergame.domain.Results;
import laddergame.domain.strategy.BuildStrategy;
import laddergame.domain.strategy.PointBuildStrategy;
import laddergame.view.InputView;
import laddergame.view.OutputView;

public class LadderGame {
    private final InputView inputView = InputView.getInstance();
    private final OutputView outputView = OutputView.getInstance();

    public void run() {
        Players players = requestUntilValidated(() -> Players.from(inputView.readPlayersName()));
        Results results = requestUntilValidated(
                () -> Results.from(inputView.readResultNames(), players.getPlayers().size()));
        Height height = requestUntilValidated(() -> new Height(inputView.readLadderHeight()));
        BuildStrategy pointBuildStrategy = new PointBuildStrategy();
        Ladder ladder = new Ladder(players, height, results, pointBuildStrategy);
        outputView.writeLadderResult(players, ladder, results);
        PlayersResults playersResults = ladder.getPlayersResults();
        while (true) {
            final String name = requestUntilValidated(() -> inputView.readDesiredPlayerName(players));
            if (name.equals("all")) {
                outputView.writeAllResults(playersResults);
                break;
            }
            outputView.writeDesiredResult(playersResults.find(name));
        }
    }

    private <T> T requestUntilValidated(Supplier<T> supplier) {
        try {
            return supplier.get();
        } catch (IllegalArgumentException e) {
            OutputView.writeErrorMessage(e.getMessage());
            return requestUntilValidated(supplier);
        }
    }
}
