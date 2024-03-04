package controller;

import common.Command;
import domain.ladder.Floor;
import domain.ladder.LadderGenerator;
import domain.ladder.LadderClimbingGame;
import domain.ladder.LadderHeight;
import domain.ladder.strategy.RandomBridgeGenerator;
import domain.player.PlayerName;
import domain.player.PlayerNames;
import domain.result.ClimbingResults;
import domain.result.LadderResult;
import domain.result.LadderResults;
import java.util.List;
import java.util.stream.IntStream;
import view.InputView;
import view.OutputView;

public class LadderController {
    private final InputView inputView;
    private final OutputView outputView;
    private final RetryHandler retryHandler;

    public LadderController(final InputView inputView, final OutputView outputView, final RetryHandler retryHandler) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.retryHandler = retryHandler;
    }

    public void start() {
        PlayerNames playerNames = readPlayerNames();
        LadderHeight ladderHeight = readLadderHeight();
        LadderGenerator ladderGenerator = new LadderGenerator(ladderHeight, playerNames, new RandomBridgeGenerator());
        List<Floor> ladder = ladderGenerator.generateLadder();
        LadderResults ladderResults = readLadderResultCountOf(playerNames.getPlayerCount());
        outputView.printInputtedResultsOf(playerNames, ladder, ladderResults);
        LadderClimbingGame ladderClimbingGame = new LadderClimbingGame(playerNames, ladder, ladderResults);
        ClimbingResults climbingResults = ladderClimbingGame.createClimbingResults();
        findResultBy(climbingResults);
    }

    private PlayerNames readPlayerNames() {
        return retryHandler.retry(() -> createPlayers(inputView.readPlayerNames()));
    }

    private PlayerNames createPlayers(final List<String> playerNames) {
        List<PlayerName> players = IntStream.range(0, playerNames.size())
                .mapToObj(name -> new PlayerName(playerNames.get(name)))
                .toList();
        return new PlayerNames(players);
    }

    private LadderHeight readLadderHeight() {
        return retryHandler.retry(() -> new LadderHeight(inputView.readLadderHeight()));
    }

    private LadderResults readLadderResultCountOf(int playerCount) {
        return retryHandler.retry(() -> createLadderResultCountOf(playerCount, inputView.readLadderResults()));
    }

    private LadderResults createLadderResultCountOf(int playerCount, final List<String> ladderResults) {
        List<LadderResult> results = IntStream.range(0, ladderResults.size())
                .mapToObj(result -> new LadderResult(ladderResults.get(result)))
                .toList();
        return LadderResults.createMatchesCountOf(playerCount, results);
    }

    private void findResultBy(final ClimbingResults climbingResults) {
        String playerName = inputView.readPlayerToSeeResult();
        while (!playerName.equals(Command.FINISH.getValue())) {
            findResultByPlayerName(playerName, climbingResults);
            playerName = inputView.readPlayerToSeeResult();
        }
        outputView.printAllClimbingLadderResults(climbingResults.getAllResults());
    }

    private void findResultByPlayerName(final String playerName, final ClimbingResults climbingResults) {
        try {
            LadderResult result = climbingResults.findResultByPlayerName(playerName);
            outputView.printSingleClimbingLadderResult(result.getValue());
        } catch (Exception exception) {
            outputView.printErrorMessage(exception.getMessage());
        }
    }
}
