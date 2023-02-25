package controller;

import domain.*;
import factory.LadderFactory;
import factory.PlayersFactory;
import view.InputView;
import view.OutputView;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

public class LadderGameController {

    private static final String END_CONDITION = "all";
    private LadderGame ladderGame;

    public void play() {
        ready();
        printGeneratedLadder();
        printResultOfSinglePlayer(InputView.readPlayerName());
        printAllPlayers();
    }

    private void printAllPlayers() {
        LinkedHashMap<String, GameResult> gameResults = ladderGame.getGameResultsOfAllPlayers();
        OutputView.printGameResult(gameResults);
    }

    private void printResultOfSinglePlayer(String playerName) {
        while (!playerName.equals(END_CONDITION)) {
            GameResult gameResult = ladderGame.getGameResultOf(playerName);
            OutputView.printGameResult(gameResult.getResult());
            playerName = InputView.readPlayerName();
        }
    }

    private void ready() {
        List<String> playerNames = InputView.readPlayerNames();
        Players players = PlayersFactory.of(playerNames);
        List<String> gameResultNames = InputView.readGameResultNames();
        GameResults gameResults = createGameResults(playerNames.size(), gameResultNames);
        int ladderHeight = InputView.readLadderHeight();
        Ladder ladder = LadderFactory.of(playerNames.size(), ladderHeight, new RandomBasedStrategy());
        ladderGame = new LadderGame(players, ladder, gameResults);
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
                .map(GameResult::getResult)
                .collect(Collectors.toList());
    }

    private GameResults createGameResults(int playersSize, List<String> gameResultNames) {
        return new GameResults(
                playersSize,
                gameResultNames.stream().map(GameResult::new).collect(Collectors.toList())
        );
    }

    private List<List<Boolean>> getPointValues(List<Line> lines) {
        return lines.stream()
                .map(Line::getPoints)
                .map(LadderGameController::convertPointsToValues)
                .collect(Collectors.toList());
    }

    public static List<Boolean> convertPointsToValues(List<Point> points) {
        return points.stream()
                .map(Point::isExist)
                .collect(Collectors.toUnmodifiableList());
    }

}
