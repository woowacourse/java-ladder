package controller;

import domain.Height;
import domain.Players;
import domain.ladder.Ladder;
import util.RandomNumberGenerator;
import view.InputView;
import view.OutputView;

public class LadderGameController {

    private final InputView inputView;
    private final OutputView outputView;
    private final RandomNumberGenerator randomNumberGenerator;

    public LadderGameController(RandomNumberGenerator randomNumberGenerator) {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public void run() {
        Players players = Players.from(inputView.requestPlayerNames());
        Height height = new Height(inputView.requestLadderHeight());

        Ladder ladder = Ladder.of(players, height, randomNumberGenerator);
        ladder.buildBridges();

        printLadderGameResult(players, ladder);
    }

    private void printLadderGameResult(Players players, Ladder ladder) {
        outputView.printLadderResultPrefix();
        outputView.printPlayerNames(players);
        outputView.printLadder(ladder);
    }

    public void printError(Exception exception) {
        outputView.printError(exception);
    }

}
