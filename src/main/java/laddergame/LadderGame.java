package laddergame;

import java.io.IOException;
import java.util.List;
import java.util.stream.IntStream;
import laddergame.domain.Ladder;
import laddergame.domain.Players;
import laddergame.domain.strategy.CanBuildStrategy;
import laddergame.domain.strategy.RandomBuildStrategy;
import laddergame.view.InputView;
import laddergame.view.OutputView;

public class LadderGame {

    public void run() {
        try {
            InputView inputView = new InputView();
            Players players = Players.from(inputView.readPlayersName());
            System.out.println();
            int height = inputView.readLadderHeight();

            Ladder ladder = new Ladder(players.getPlayerNames().size(), height);

            CanBuildStrategy randomBuildStrategy = new RandomBuildStrategy();
            List<List<Boolean>> randomResult = IntStream.range(0, height)
                    .mapToObj(i -> randomBuildStrategy.canBuildBridges(players.getPlayerNames().size() - 1))
                    .toList();

            ladder.build(randomResult);

            OutputView outputView = new OutputView();
            printLadderResult(players, ladder, outputView);
        } catch (IOException exception) {

        }
    }

    private static void printLadderResult(Players players, Ladder ladder, OutputView outputView) {
        outputView.writeResultTitle();
        outputView.writePlayersName(players.getPlayerNames());
        outputView.writeLadder(ladder);
    }
}
