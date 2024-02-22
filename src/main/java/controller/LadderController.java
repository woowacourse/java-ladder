package controller;

import model.Height;
import model.Ladder;
import model.Players;
import view.InputView;
import view.OutputView;

public class LadderController {
    private final InputView inputView;
    private final OutputView outputView;

    public LadderController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        Players players = new Players(inputView.readPlayersName());
        Height height = new Height(inputView.readHeight());

        Ladder ladder = Ladder.of(height, players.size());

        outputView.printResult(players.getNames(), ladder.getLines());
    }
}
