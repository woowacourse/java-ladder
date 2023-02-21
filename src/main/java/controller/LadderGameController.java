package controller;

import domain.*;
import factory.LadderFactory;
import factory.PlayersFactory;
import view.InputView;
import view.OutputView;

import java.util.List;
import java.util.stream.Collectors;

public class LadderGameController {

    private LadderGame ladderGame;

    public void play() {
        ready();
        printGeneratedLadder();
    }

    private void ready() {
        List<String> playerNames = InputView.readPlayerNames();
        Players players = PlayersFactory.of(playerNames);
        int ladderHeight = InputView.readLadderHeight();
        Ladder ladder = LadderFactory.of(playerNames.size(), ladderHeight, new RandomBasedStrategy());
        ladderGame = new LadderGame(players, ladder);
    }

    private void printGeneratedLadder() {
        Ladder ladder = ladderGame.getLadder();
        List<Line> lines = ladder.getLines();
        List<List<Boolean>> pointValues = getPointValues(lines);
        OutputView.printGeneratedLadder(ladderGame.getPlayerNames(), pointValues);
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
