package ladder.controller;

import ladder.domain.Height;
import ladder.domain.Ladder;
import ladder.domain.Players;
import ladder.domain.RandomGenerator;
import ladder.view.InputView;
import ladder.view.ResultView;

import java.util.List;

public class LadderController {

    private final InputView inputView;
    private final ResultView resultView;
    private final RandomGenerator randomGenerator;

    public LadderController(InputView inputView, ResultView resultView, RandomGenerator randomGenerator) {
        this.inputView = inputView;
        this.resultView = resultView;
        this.randomGenerator = randomGenerator;
    }

    public void run() {
        Players players = newPlayersUntilNoException();
        Height heightOfLadder = newHeightOfLadderUntilNoException();
        Ladder ladder = Ladder.create(players.count(), heightOfLadder.getHeight());

        resultView.printLadder(players, ladder);
    }

    private Players newPlayers() {
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

    private Players newPlayersUntilNoException() {
        Players players = null;
        while (players == null) {
            players = newPlayers();
        }
        return players;
    }

    private Height newHeightOfLadderUntilNoException() {
        Height height = null;
        while (height == null) {
            height = newHeightOfLadder();
        }
        return height;
    }

}
