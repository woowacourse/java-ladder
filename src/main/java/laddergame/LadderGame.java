package laddergame;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.IntStream;
import laddergame.domain.Ladder;
import laddergame.domain.Players;
import laddergame.domain.strategy.CanBuildStrategy;
import laddergame.domain.strategy.RandomBuildStrategy;
import laddergame.view.InputView;
import laddergame.view.OutputView;

public class LadderGame {

    public void run() {
        InputView inputView = new InputView();
        Players players = requestUntilValidated(() -> Players.from(inputView.readPlayersName()));
        System.out.println();
        String height = requestUntilValidated(inputView::readLadderHeight);

        Ladder ladder = new Ladder(players.getPlayerNames().size(), height);

        CanBuildStrategy randomBuildStrategy = new RandomBuildStrategy();
        List<List<Boolean>> randomResult = IntStream.range(0, ladder.getHeight())
                .mapToObj(i -> randomBuildStrategy.canBuildBridges(players.getPlayerNames().size() - 1))
                .toList();

        ladder.build(randomResult);

        OutputView outputView = new OutputView();
        printLadderResult(players, ladder, outputView);
    }

    private static void printLadderResult(Players players, Ladder ladder, OutputView outputView) {
        outputView.writeResultTitle();
        outputView.writePlayersName(players.getPlayerNames());
        outputView.writeLadder(ladder);
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
