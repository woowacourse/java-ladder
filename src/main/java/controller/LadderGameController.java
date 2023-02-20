package controller;

import domain.Height;
import domain.LadderGame;
import domain.PlayerNames;
import domain.ResultContents;
import domain.ladder.Ladder;
import domain.ladder.strategy.GenerateBridgeStrategy;
import view.InputView;
import view.OutputView;

public class LadderGameController {

    private final InputView inputView;
    private final OutputView outputView;
    private final GenerateBridgeStrategy bridgeStrategy;

    public LadderGameController(InputView inputView, OutputView outputView, GenerateBridgeStrategy bridgeStrategy) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.bridgeStrategy = bridgeStrategy;
    }

    public LadderGame initGame() {
        PlayerNames playerNames = getPlayerNames();
        ResultContents resultContents = getResultContents();
        Ladder ladder = buildLadder(playerNames);

        return new LadderGame(ladder, playerNames, resultContents);
    }

    public void run(LadderGame ladderGame) {
        ladderGame.buildBridges();
        printLadderGameResult(ladderGame);
    }

    private Ladder buildLadder(PlayerNames playerNames) {
        Height height = inputView.requestLadderHeight();
        return Ladder.of(playerNames, height, bridgeStrategy);
    }

    private ResultContents getResultContents() {
        String resultContentsInput = inputView.requestResultContents();
        return ResultContents.of(
                resultContentsInput, inputView.getResultContentsDelimiter());
    }

    private PlayerNames getPlayerNames() {
        String playerNamesInput = inputView.requestPlayerNames();
        return PlayerNames.of(playerNamesInput, inputView.getPlayerNameDelimiter());
    }

    private void printLadderGameResult(LadderGame ladderGame) {
        outputView.printResultPrefix();
        outputView.printPlayerNames(ladderGame.getPlayerNames());
        outputView.printLadder(ladderGame.getLadder());
        outputView.printResult(ladderGame.getResultContents());
    }

    public void printError(Exception exception) {
        outputView.printError(exception);
    }

}
