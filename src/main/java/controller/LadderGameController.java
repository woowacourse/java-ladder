package controller;

import domain.*;
import factory.PlayersFactory;
import view.InputView;
import view.OutputView;

import java.util.List;
import java.util.stream.Collectors;

public class LadderGameController {

    private final InputView inputView;
    private final OutputView outputView;
    private LadderGame ladderGame;
    private Players players;

    public LadderGameController(final InputView inputView, final OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void play() {
        ready();
        printGeneratedLadder();
    }

    private void ready() {
        List<String> playerNames = inputView.readPlayerNames();
        int ladderHeight = inputView.readLadderHeight();
        players = PlayersFactory.generate(playerNames);
        ladderGame = new LadderGame(players, ladderHeight);
    }

    private void printGeneratedLadder() {
        Ladder ladder = ladderGame.getLadder();
        List<Line> lines = ladder.getLines();
        List<List<Boolean>> pointValues = getPointValues(lines);
        outputView.printGeneratedLadder(ladderGame.getPlayerNames(), pointValues);
    }

    private List<List<Boolean>> getPointValues(List<Line> lines) {
        return lines.stream()
                .map(Line::getPoints)
                .map(Point::convertPointsToValues)
                .collect(Collectors.toList());
    }

}
