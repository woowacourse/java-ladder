package controller;

import domain.Height;
import domain.Ladder;
import domain.Players;
import util.TrueOrFalseGenerator;
import view.InputView;
import view.OutputView;

public class LadderGameController {
    private final InputView inputView;
    private final OutputView outputView;
    private final TrueOrFalseGenerator trueOrFalseGenerator;

    public LadderGameController(InputView inputView, OutputView outputView, TrueOrFalseGenerator trueOrFalseGenerator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.trueOrFalseGenerator = trueOrFalseGenerator;
    }

    public void run() {
        Players players = Players.generatePlayers(inputView.readUserNames());
        Height height = new Height(inputView.readHeight());
        Ladder ladder = Ladder.generateLadder(players, height, trueOrFalseGenerator);
        outputView.printResult(players, ladder);
    }
}
