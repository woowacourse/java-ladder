package controller;

import domain.LadderGame;
import domain.ResultContents;
import domain.ladder.Height;
import domain.ladder.Ladder;
import domain.ladder.strategy.GenerateBridgeStrategy;
import domain.player.Player;
import domain.player.PlayerNames;
import domain.player.Players;
import java.util.List;
import view.util.formatter.LadderConsoleViewFormatter;
import view.util.formatter.PlayersConsoleViewFormatter;
import view.util.formatter.ResultContentsConsoleViewFormatter;
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
        List<String> playerNamesInput = inputView.requestPlayerNames();
        PlayerNames playerNames = PlayerNames.from(playerNamesInput);
        return Players.from(playerNames);
    }

    private ResultContents getResultContents() {
        String resultContentsInput = inputView.requestResultContents();
        return ResultContents.of(
                resultContentsInput, inputView.getResultContentsDelimiter());
    }

    private Ladder buildLadderByPlayerAmount(int playerAmount) {
        int heightInput = inputView.requestLadderHeight();
        Height height = new Height(heightInput);
        return Ladder.of(playerAmount, height, bridgeStrategy);
    }

    private void printLadderGameResult(LadderGame ladderGame) {
        outputView.printLadderResultPrefix();
        String playersFormat = PlayersConsoleViewFormatter.formatPlayers(ladderGame.getPlayers());
        outputView.printFormat(playersFormat);

        String ladderFormat = LadderConsoleViewFormatter.formatLadder(ladderGame.getLadder());
        outputView.printFormat(ladderFormat);

        String resultContentsFormat = ResultContentsConsoleViewFormatter.formatResultContents(
                ladderGame.getResultContents());
        outputView.printFormat(resultContentsFormat);
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
            String playersResultFormat = PlayersConsoleViewFormatter.formatResultPlayers(players);
            outputView.printAllResultPrefix();
            outputView.printFormat(playersResultFormat);
            return;
        }

        Player playerByName = players.findByName(userRequest);
        outputView.printPlayerResult(playerByName.getResultContent());
    }

    public void printError(Exception exception) {
        outputView.printError(exception);
    }

}
