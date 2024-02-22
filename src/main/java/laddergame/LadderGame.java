package laddergame;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.IntStream;
import laddergame.domain.Ladder;
import laddergame.domain.Players;
import laddergame.domain.strategy.CanBuildStrategy;
import laddergame.domain.strategy.RandomBuildStrategy;
import laddergame.dto.LineBuildResult;
import laddergame.view.InputView;
import laddergame.view.OutputView;

public class LadderGame {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void run() {
        Players players = requestUntilValidated(() -> Players.from(inputView.readPlayersName()));
        String height = requestUntilValidated(inputView::readLadderHeight);

        Ladder ladder = new Ladder(players.getPlayers().size(), height);
        ladder.build(getLineBuildResults(players, ladder));
        printLadderResult(players, ladder);
    }

    private static List<LineBuildResult> getLineBuildResults(final Players players, final Ladder ladder) {
        CanBuildStrategy randomBuildStrategy = new RandomBuildStrategy();
        return IntStream.range(0, ladder.getHeight())
                .mapToObj(i -> randomBuildStrategy.canBuildBridges(players.getPlayers().size() - 1))
                .toList();
    }

    private void printLadderResult(final Players players, final Ladder ladder) {
        outputView.writeResultTitle();
        outputView.writePlayersName(players);
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
