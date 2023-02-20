package ladder.controller;

import java.util.List;
import ladder.domain.BooleanGenerator;
import ladder.domain.LadderGame;
import ladder.domain.Line;
import ladder.domain.Players;
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
        final LadderGame ladderGame = initializeLadderGame();
        final List<String> players = ladderGame.getPlayers();
        final List<Line> ladder = ladderGame.getLadder();

        outputView.printResult(players, ladder);
    }

    private LadderGame initializeLadderGame() {
        final Players players = readPlayers();
        final int height = readHeight();
        return readLadderGame(players, height);
    }

    private Players readPlayers() {
        try {
            final List<String> names = inputView.readPlayerNames();
            return new Players(names);
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            return readPlayers();
        }
    }

    private int readHeight() {
        try {
            return inputView.readLadderHeight();
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            return readHeight();
        }
    }

    private LadderGame readLadderGame(final Players players, final int height) {
        try {
            return new LadderGame(booleanGenerator, players, height);
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            return readLadderGame(players, height);
        }
    }
}
