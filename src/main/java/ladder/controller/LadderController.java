package ladder.controller;

import ladder.domain.Height;
import ladder.domain.Ladder;
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

    private Height newHeightOfLadder() {
        try {
            int inputMaximumHeight = inputView.inputHeightOfLadder();
            return Height.create(inputMaximumHeight, randomGenerator);
        } catch (IllegalArgumentException e) {
            resultView.printError(e.getMessage());
            return null;
        }
    }
}
