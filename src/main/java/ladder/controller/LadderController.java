package ladder.controller;

import ladder.domain.Bar;
import ladder.domain.Height;
import ladder.domain.Ladder;
import ladder.domain.Line;
import ladder.domain.LineMaker;
import ladder.domain.Players;
import ladder.domain.RandomGenerator;
import ladder.view.InputView;
import ladder.view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class LadderController {

    private static final int MINIMUM_HEIGHT = 1;

    private final InputView inputView;
    private final ResultView resultView;
    private final RandomGenerator randomIntegerGenerator;

    public LadderController(InputView inputView, ResultView resultView, RandomGenerator randomIntegerGenerator) {
        this.inputView = inputView;
        this.resultView = resultView;
        this.randomIntegerGenerator = randomIntegerGenerator;
    }

    public void run() {
        Players players = createPlayersUntilNoException();
        Height heightOfLadder = decideHeightOfLadderUntilNoException();
        Ladder ladder = Ladder.create(players.count(), heightOfLadder.getHeight());

        resultView.printLadder(players, ladder);
    }

    private Players createPlayersUntilNoException() {
        Players players = null;
        while (players == null) {
            players = createPlayers();
        }
        return players;
    }

    private Players createPlayers() {
        try {
            List<String> inputNames = inputView.inputPlayerNames();
            return Players.create(inputNames);
        } catch (IllegalArgumentException e) {
            resultView.printError(e.getMessage());
            return null;
        }
    }

    private Height decideHeightOfLadderUntilNoException() {
        Height height = null;
        while (height == null) {
            height = decideHeightOfLadder();
        }
        return height;
    }

    private Height decideHeightOfLadder() {
        try {
            int inputMaximumHeight = inputView.inputHeightOfLadder();
            int height = randomIntegerGenerator.generateNumber(MINIMUM_HEIGHT, inputMaximumHeight);
            return new Height(height);
        } catch (IllegalArgumentException e) {
            resultView.printError(e.getMessage());
            return null;
        }
    }
}
