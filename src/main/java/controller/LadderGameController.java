package controller;

import domain.ladder.Height;
import domain.LadderGame;
import domain.player.Player;
import domain.player.PlayerNames;
import domain.player.Players;
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
        Players players = getPlayers();
        ResultContents resultContents = getResultContents();
        Ladder ladder = buildLadderByPlayerAmount(players.playerAmount());

        return new LadderGame(ladder, players, resultContents);
    }

    public void run(LadderGame ladderGame) {
        ladderGame.buildBridges();
        ladderGame.runGame();
        printLadderGameResult(ladderGame);

        requestSpecificPlayerResult(ladderGame.getPlayers());
    }

    private Players getPlayers() {
        String playerNamesInput = inputView.requestPlayerNames();
        PlayerNames playerNames = PlayerNames.of(playerNamesInput, inputView.getPlayerNameDelimiter());
        return Players.from(playerNames);
    }

    private ResultContents getResultContents() {
        String resultContentsInput = inputView.requestResultContents();
        return ResultContents.of(
                resultContentsInput, inputView.getResultContentsDelimiter());
    }

    private Ladder buildLadderByPlayerAmount(int playerAmount) {
        Height height = inputView.requestLadderHeight();
        return Ladder.of(playerAmount, height, bridgeStrategy);
    }

    private void printLadderGameResult(LadderGame ladderGame) {
        outputView.printResultPrefix();
        outputView.printPlayerNames(ladderGame.getPlayers());
        outputView.printLadder(ladderGame.getLadder());
        outputView.printResult(ladderGame.getResultContents());
    }

    private void requestSpecificPlayerResult(Players players) {
        String userRequest = new String();
        while (!userRequest.equals(inputView.getResultEndCommand())) {
            userRequest = inputView.requestResultPlayer();
            printPlayerResult(userRequest, players);
        }
    }

    private void printPlayerResult(String userRequest, Players players) {
        if (userRequest.equals(inputView.getResultEndCommand())) {
            outputView.printAllResults(players);
            return;
        }

        Player playerByName = players.findByName(userRequest);
        outputView.printPlayerResult(playerByName.getResultContent());
    }

    public void printError(Exception exception) {
        outputView.printError(exception);
    }

}
