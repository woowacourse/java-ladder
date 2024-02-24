package laddergame;

import java.util.function.Supplier;
import laddergame.domain.Height;
import laddergame.domain.Ladder;
import laddergame.domain.Players;
import laddergame.domain.Result;
import laddergame.domain.Results;
import laddergame.domain.strategy.BuildStrategy;
import laddergame.domain.strategy.PointBuildStrategy;
import laddergame.view.InputView;
import laddergame.view.OutputView;

public class LadderGame {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void run() {
        Players players = requestUntilValidated(() -> Players.from(inputView.readPlayersName()));
        Results results = requestUntilValidated(
                () -> Results.from(inputView.readResultNames(), players.getPlayers().size()));
        Height height = requestUntilValidated(() -> new Height(inputView.readLadderHeight()));
        BuildStrategy pointBuildStrategy = new PointBuildStrategy();
        Ladder ladder = new Ladder(players, height, results, pointBuildStrategy);
        outputView.printLadderResult(players, ladder, results);
        Result result = requestUntilValidated(() -> new Result(inputView.readDesiredResultName()));
    }

    private <T> T requestUntilValidated(Supplier<T> supplier) {
        try {
            return supplier.get();
        } catch (IllegalArgumentException e) {
            OutputView.writeErrorMessage("입력이 잘못되었습니다. 다시 입력해주세요.");
            return requestUntilValidated(supplier);
        }
    }
}
