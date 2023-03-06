package controller;

import domain.*;
import util.BooleanGenerator;
import util.RandomBooleanGenerator;
import view.InputView;
import view.OutputView;

import java.util.Arrays;
import java.util.Map;

public class LadderController {

    public void run() {
        Players players = makePlayers();
        Results results = makeResults(players);
        Ladder ladder = makeLadder(players);
        ladder.generateRandomLadder();
        printLadder(players, ladder);
        MatchingResult matchingResult = playLadderGame(ladder, players, results);
        printMatchingResult(matchingResult, players);
    }

    private Players makePlayers() {
        try {
            String[] playerNames = InputView.receivePlayers();
            return Players.from(playerNames);
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

    private MatchingResult playLadderGame(Ladder ladder, Players players, Results results) {
        ladder.movePlayers(players);
        return results.matchResults(players);
    }

    private void printMatchingResult(MatchingResult matchingResult, Players players) {
        try {
            String[] matchingNames = InputView.receiveMatchingName();
            printAllResults(matchingResult, matchingNames);
            printFinalResult(matchingResult, players, matchingNames);
        } catch (IllegalArgumentException e) {
            OutputView.printMessage(e.getMessage());
            printMatchingResult(matchingResult, players);
        }
    }

    private void printAllResults(MatchingResult matchingResult, String[] matchingNames) {
        if (matchingNames[0].equals("all")) {
            OutputView.printAllResults(matchingResult);
        }
    }

    private void printFinalResult(MatchingResult matchingResult, Players players, String[] matchingNames) {
        if (Arrays.stream(matchingNames).noneMatch(name -> name.equals("all"))) {
            Map<Player, Result> finalResult = matchingResult.getFinalResult(players, matchingNames);
            OutputView.printFinalResult(finalResult);
        }
    }
}
