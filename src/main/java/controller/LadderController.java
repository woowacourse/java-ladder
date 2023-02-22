package controller;

import domain.Height;
import domain.Ladder;
import domain.Line;
import domain.Lines;
import domain.Players;
import java.util.ArrayList;
import java.util.List;
import util.LineGenerator;
import util.PlayersMaker;
import util.RandomLineGenerator;
import view.InputView;
import view.OutputView;

public class LadderController {

    public void run() {
        Players players = makePlayers();
        int height = inputHeight();
        Ladder ladder = makeLadder(new Height(height), players.getNumberOfPlayers());
        printLadder(players, ladder);
    }

    private Players makePlayers() {
        try {
            String playersName = inputPlayers();
            return PlayersMaker.makePlayers(playersName);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e);
            return makePlayers();
        }
    }

    private String inputPlayers() {
        try{
            return InputView.receivePlayer();
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e);
            return inputPlayers();
        }
    }

    private int inputHeight() {
        try {
            return InputView.receiveHeight();
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e);
            return inputHeight();
        }
    }

    private Ladder makeLadder(Height height, int numberOfWalls) {
        LineGenerator lineGenerator = new RandomLineGenerator();
        Lines lines = makeLines(height, numberOfWalls, lineGenerator);

        return new Ladder(lines, height);
    }

    private Lines makeLines(Height height, int numberOfWalls, LineGenerator lineGenerator) {
        List<Line> lines = new ArrayList<>();
        int numberOfLine = numberOfWalls - 1;

        for (int i = 0; i < height.getHeight(); i++) {
            lines.add(new Line(numberOfLine, lineGenerator));
        }

        return new Lines(lines);
    }

    private void printLadder(Players players, Ladder ladder) {
        OutputView.printResultMessage();
        OutputView.printPlayers(players);
        OutputView.printLadder(ladder);
    }
}
