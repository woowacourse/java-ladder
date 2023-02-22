package controller;

import domain.*;
import view.InputView;
import view.OutputView;

import java.util.List;

public class Controller {
    private final InputView inputView;
    private final OutputView outputView;
    private final BooleanCreator booleanCreator;

    public Controller(InputView inputView, OutputView outputView, BooleanCreator booleanCreator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.booleanCreator = booleanCreator;
    }

    public void run() {
        PlayerNames playerNames = new PlayerNames(inputView.readPlayerNames(), inputView);
        Players players = new Players(playerNames);

        int ladderHeight = new LadderHeight(inputView.readLadderHeight(), inputView).getLadderHeight();
        List<Line> ladder = new Ladder(ladderHeight, players, booleanCreator).getLadder();

        printResult(players, ladder);
    }

    private void printResult(Players players, List<Line> ladder) {
        outputView.printNames(players);
        outputView.printLadders(ladder);
    }
}
