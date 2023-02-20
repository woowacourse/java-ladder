package controller;

import domain.Height;
import domain.PlayerNames;
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
        PlayerNames playerNames = PlayerNames.from(inputView.requestPlayerNames());
        Height height = new Height(inputView.requestLadderHeight());

        Ladder ladder = Ladder.of(playerNames, height, randomNumberGenerator);
        ladder.buildBridges();

        printLadderGameResult(playerNames, ladder);
    }

    private void printLadderGameResult(PlayerNames playerNames, Ladder ladder) {
        outputView.printResultPrefix();
        outputView.printPlayerNames(playerNames);
        outputView.printResult(ladder);
    }

    public void printError(Exception exception) {
        outputView.printError(exception);
    }

}
