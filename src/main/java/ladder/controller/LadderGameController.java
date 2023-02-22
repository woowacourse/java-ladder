package ladder.controller;

import java.util.List;
import ladder.domain.BooleanGenerator;
import ladder.domain.Height;
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
        final Players players = readPlayers();
        final List<String> results = readResults(players);
        final Height height = readHeight();

        final LadderGame ladderGame = new LadderGame(booleanGenerator, players, height);

        final List<String> playerNames = ladderGame.getPlayerNames();
        final List<Line> ladder = ladderGame.getLadder();

        outputView.printResult(playerNames, ladder, results);
    }

    private List<String> readResults(final Players players) {
        try {
            List<String> results = inputView.readResult();
            players.validateSameSize(results);
            return results;
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            return readResults(players);
        }
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

    private Height readHeight() {
        try {
            int input = inputView.readLadderHeight();
            return new Height(input);
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            return readHeight();
        }
    }
}
