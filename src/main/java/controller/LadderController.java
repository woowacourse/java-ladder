package controller;

import domain.*;
import util.BooleanGenerator;
import util.RandomBooleanGenerator;
import view.InputView;
import view.OutputView;

import java.util.Map;

public class LadderController {

    public void run() {
        Players players = makePlayers();
        Results results = makeResults(players);
        Ladder ladder = makeLadder(players);
        ladder.generateRandomLadder();
        printLadder(players, ladder);
        Map<Player, Result> matchingResult = playLadderGame(ladder, players, results);
    }

    private Players makePlayers() {
        try {
            String[] playerNames = InputView.receivePlayers();
            return Players.of(playerNames);
        } catch (IllegalArgumentException e) {
            OutputView.printMessage(e.getMessage());
            return makePlayers();
        }
    }

    private Results makeResults(Players players) {
        try {
            String[] resultNames = InputView.receiveResults();
            return Results.of(resultNames, players.getNumberOfPlayers());
        } catch (IllegalArgumentException e) {
            OutputView.printMessage(e.getMessage());
            return makeResults(players);
        }
    }

    private Ladder makeLadder(Players players) {
        BooleanGenerator booleanGenerator = new RandomBooleanGenerator();
        try {
            int height = InputView.receiveHeight();
            return Ladder.makeDefaultLadder(players.getNumberOfPlayers(), new Height(height).getHeight(), booleanGenerator);
        } catch (IllegalArgumentException e) {
            OutputView.printMessage(e.getMessage());
            return makeLadder(players);
        }
    }

    private void printLadder(Players players, Ladder ladder) {
        OutputView.printResultMessage();
        OutputView.printPlayers(players);
        OutputView.printLadder(ladder);
    }

    private Map<Player, Result> playLadderGame(Ladder ladder, Players players, Results results) {
        ladder.movePlayer(players);
        return results.matchResults(players);

    }

}
