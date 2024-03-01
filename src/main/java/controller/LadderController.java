package controller;

import domain.ladder.Ladder;
import domain.ladder.LadderHeight;
import domain.ladder.strategy.RandomBridgeGenerator;
import domain.player.Player;
import domain.player.PlayerName;
import domain.player.Players;
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
        Players players = readPlayerNames();
        List<LadderResult> ladderResultsOfEntered = createLadderResults();
        LadderHeight ladderHeight = readLadderHeight();
        Ladder ladder = Ladder.of(ladderHeight, players, new RandomBridgeGenerator());
        LadderResults ladderResults = LadderResults.createMatchesCountOf(players.getPlayerCount(), ladderResultsOfEntered);
        outputView.printInputtedResultsOf(players, ladder, ladderResults);
        ClimbingResults climbingResults = ClimbingResults.of(players, ladder, ladderResults);
        startClimbingLadder(climbingResults);
    }

    private Players readPlayerNames() {
        return retryHandler.retry(() -> createPlayers(inputView.readPlayerNames()));
    }

    private Players createPlayers(final List<String> playerNames) {
        List<Player> players = IntStream.range(0, playerNames.size())
                .mapToObj(name -> new Player(new PlayerName(playerNames.get(name)), name))
                .toList();
        return new Players(players);
    }

    private LadderHeight readLadderHeight() {
        return retryHandler.retry(() -> new LadderHeight(inputView.readLadderHeight()));
    }

    private List<LadderResult> createLadderResults() {
        List<String> ladderResults = retryHandler.retry(() -> inputView.readLadderResults());
        return ladderResults.stream()
                .map(LadderResult::new)
                .toList();
    }

    private void startClimbingLadder(final ClimbingResults climbingResults) {
        String playerName = inputView.readPlayerToSeeResult();
        while (!playerName.equals(InputView.FINISH_COMMAND)) {
            findResultByPlayerName(playerName, climbingResults);
            playerName = inputView.readPlayerToSeeResult();
        }
        outputView.printAllClimbingLadderResults(climbingResults.getAllResults());
    }

    private void findResultByPlayerName(final String playerName, final ClimbingResults climbingResults) {
        try {
            String result = climbingResults.findResultByPlayerName(playerName);
            outputView.printSingleClimbingLadderResult(result);
        } catch (IllegalArgumentException exception) {
            outputView.printErrorMessage(exception.getMessage());
        }
    }
}
