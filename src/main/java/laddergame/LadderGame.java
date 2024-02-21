package laddergame;

import java.io.IOException;
import java.util.List;
import java.util.stream.IntStream;
import laddergame.domain.Ladder;
import laddergame.domain.strategy.CanBuildStrategy;
import laddergame.domain.strategy.RandomBuildStrategy;
import laddergame.view.InputView;
import laddergame.view.OutputView;

public class LadderGame {

    public void run() {
        try {
            InputView inputView = new InputView();
            List<String> players = inputView.readPlayersName();
            System.out.println();
            int height = inputView.readLadderHeight();

            Ladder ladder = new Ladder(players.size(), height);

            CanBuildStrategy randomBuildStrategy = new RandomBuildStrategy();
            List<List<Boolean>> randomResult = IntStream.range(0, height).mapToObj(i ->
                    randomBuildStrategy.canBuildBridges(players.size() - 1)).toList();

            ladder.build(randomResult);

            OutputView outputView = new OutputView();
            outputView.writePlayersName(players);
            outputView.writeLadder(ladder);
        } catch (IOException exception) {

        }
    }
}
