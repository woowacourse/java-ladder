package controller;

import domain.*;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class Controller {

    public static final int FIRST_FLOOR = 0;
    public static final int SECOND_BLOCK = 1;

    private InputView inputView;
    private OutputView outputView;
    private BooleanGenerator booleanGenerator;

    public Controller(InputView inputView, OutputView outputView, BooleanGenerator booleanGenerator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.booleanGenerator = booleanGenerator;
    }

    public void run() {
        List<String> playerNames = inputView.readPlayerName();
        Players players = Players.generatePlayer(playerNames);

        int ladderHeight = inputView.readLadderHeight();
        List<Line> ladder = generateLadder(ladderHeight, players);

        printResult(players, ladder);
    }

    private List<Line> generateLadder(int ladderHeight, Players players) {
        List<Line> list = new ArrayList<>();
        for (int i = FIRST_FLOOR; i < ladderHeight; i++) {
            Line line = Line.generateLine(booleanGenerator, players);
            list.add(line);
        }
        return list;
    }

    private void printResult(Players players, List<Line> ladder) {
        outputView.printNames(players);
        outputView.printLadders(ladder, players.getPlayersName());
    }
}
