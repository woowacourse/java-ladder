package controller;

import domain.*;
import factory.LadderFactory;
import factory.PlayersFactory;
import view.InputView;
import view.OutputView;

import java.util.List;
import java.util.stream.Collectors;

public class LadderGameController {

    private static final String ALL_PLAYERS = "all";

    private LadderGame ladderGame;

    public void play() {
        ready();
        printGeneratedLadder();
        printResults();
    }

    private void printResults() {
        String playerName;
        do {
            playerName = InputView.readPlayerName();
            printResults(playerName);
        } while (!playerName.equals(ALL_PLAYERS));
    }

    private void printResults(String playerName) {
        if (playerName.equals(ALL_PLAYERS)) {
            OutputView.printGameResultsOfAllPlayers(ladderGame.getGameResults());
            return;
        }
        OutputView.printGameResultOfSinglePlayer(ladderGame.getGameResultOf(playerName));
    }

    private void ready() {
        List<String> playerNames = InputView.readPlayerNames();
        Players players = PlayersFactory.of(playerNames);
        List<String> gameResultNames = InputView.readGameResultNames();
        int ladderHeight = InputView.readLadderHeight();
        Ladder ladder = LadderFactory.of(playerNames.size(), ladderHeight, new RandomBasedStrategy());
        ladderGame = new LadderGame(players, ladder, gameResultNames);
    }

    private void printGeneratedLadder() {
        List<List<Boolean>> pointValues = getLadder();
        List<String> gameGameResultNames = getGameResults();
        OutputView.printGeneratedLadder(ladderGame.getPlayerNames(), pointValues, gameGameResultNames);
    }

    private List<List<Boolean>> getLadder() {
        Ladder ladder = ladderGame.getLadder();
        List<Line> lines = ladder.getLines();
        return getPointValues(lines);
    }

    private List<String> getGameResults() {
        List<GameResult> gameResults = ladderGame.getGameResults().getGameResults();
        return gameResults.stream()
                .map(GameResult::getGameResultName)
                .collect(Collectors.toList());
    }

    private List<List<Boolean>> getPointValues(final List<Line> lines) {
        return lines.stream()
                .map(Line::getPoints)
                .map(this::convertPointsToValues)
                .collect(Collectors.toList());
    }

    private List<Boolean> convertPointsToValues(final List<Point> points) {
        return points.stream()
                .map(Point::isExist)
                .collect(Collectors.toUnmodifiableList());
    }

}
