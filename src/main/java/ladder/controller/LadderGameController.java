package ladder.controller;

import java.util.List;
import ladder.domain.BooleanGenerator;
import ladder.domain.LadderGame;
import ladder.domain.Line;
import ladder.view.InputView;
import ladder.view.OutputView;

public class LadderGameController {

    private final BooleanGenerator booleanGenerator;
    private final InputView inputView;
    private final OutputView outputView;

    public LadderGameController(
            final BooleanGenerator booleanGenerator,
            final InputView inputView,
            final OutputView outputView
    ) {
        this.booleanGenerator = booleanGenerator;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        final LadderGame ladderGame = initialize();
        final List<String> players = ladderGame.getPlayers();
        final List<Line> ladder = ladderGame.getLadder();

        outputView.printResult(players, ladder);
    }

    private LadderGame initialize() {
        final List<String> names = inputView.readPlayerNames();
        final int height = inputView.readLadderHeight();

        return new LadderGame(booleanGenerator, names, height);
    }
}
