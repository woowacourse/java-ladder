package controller;

import domain.*;
import view.InputView;
import view.OutputView;
import java.util.List;

public class Controller {

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
        Ladder ladder = Ladder.generateLadder(ladderHeight, players, booleanGenerator);

        printResult(players, ladder);
    }

    private void printResult(Players players, Ladder ladder) {
        outputView.printNames(players);
        outputView.printLadders(ladder, players.getPlayersName());
    }
}
