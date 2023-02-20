package ladder.controller;

import ladder.model.*;
import ladder.view.InputView;
import ladder.view.OutputView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LadderGameController {

    private static final String LOOK_ALL = "all";

    private final InputView inputView;
    private final OutputView outputView;
    private final LineCreateDecider lineCreateDecider;

    public LadderGameController(InputView inputView, OutputView outputView, LineCreateDecider lineCreateDecider) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lineCreateDecider = lineCreateDecider;
    }

    public void run() {
        Players players = generatePlayers();
        Results results = generateResults(players.getSize());
        Height height = generateHeight();
        Ladder ladder = generateLadder(players, height);

        showLadderGame(players, ladder, results);

        Map<String, String> matchingResults = matchPlayersAndResults(players, ladder, results);
        showMatchingResults(players, matchingResults);
    }

    private Players generatePlayers() {
        try {
            List<String> names = inputView.readNames();
            return new Players(names.stream()
                    .map(Player::new)
                    .collect(Collectors.toList()));
        } catch (IllegalArgumentException exception) {
            outputView.printExceptionMessage(exception.getMessage());
            return generatePlayers();
        }
    }

    private Results generateResults(int playerCount) {
        try {
            return new Results(inputView.readResults(), playerCount);
        } catch (IllegalArgumentException exception) {
            outputView.printExceptionMessage(exception.getMessage());
            return generateResults(playerCount);
        }
    }

    private Height generateHeight() {
        try {
            int height = inputView.readHeight();
            return new Height(height);
        } catch (IllegalArgumentException exception) {
            outputView.printExceptionMessage(exception.getMessage());
            return generateHeight();
        }
    }

    private Ladder generateLadder(Players players, Height height) {
        LadderGenerator ladderGenerator = new LadderGenerator(lineCreateDecider);
        return ladderGenerator.generateLadder(players.getSize(), height);
    }

    private void showLadderGame(Players players, Ladder ladder, Results results) {
        outputView.printLadderResultMessage();
        outputView.printPlayerNames(players.getPlayers().stream()
                .map(Player::getPlayerName)
                .collect(Collectors.toList()));

        List<Row> rows = ladder.getRows();
        for (Row row : rows) {
            outputView.printRow(row.getPoints());
        }
        outputView.printResults(results.getResults());
    }

    private Map<String, String> matchPlayersAndResults(Players players, Ladder ladder, Results results) {
        Map<String, String> matchingResults = new HashMap<>();
        for (Player player : players.getPlayers()) {
            int entrance = players.findPositionOf(player);
            int exit = ladder.findExitFrom(entrance);
            String result = results.getResults().get(exit);
            matchingResults.put(player.getPlayerName(), result);
        }
        return matchingResults;
    }

    private void showMatchingResults(Players players, Map<String, String> matchingResults) {
        String input = inputView.readPlayerChoice();
        if (input.equals(LOOK_ALL)) {
            outputView.printAllPlayerResults(matchingResults);
            return;
        }
        showChosePlayerResult(players, matchingResults, input);
        showMatchingResults(players, matchingResults);
    }

    private void showChosePlayerResult(Players players, Map<String, String> matchingResults, String input) {
        try {
            players.findPlayerByName(input);
            outputView.printChosePlayerResult(matchingResults.get(input));
        } catch (IllegalArgumentException exception) {
            outputView.printExceptionMessage(exception.getMessage());
            input = inputView.readPlayerChoice();
            showChosePlayerResult(players, matchingResults, input);
        }
    }

}
