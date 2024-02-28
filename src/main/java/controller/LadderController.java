package controller;

import model.ladder.Height;
import model.ladder.Ladder;
import model.ladder.RandomStatusGenerator;
import model.ladder.Width;
import model.players.Players;
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

        Ladder ladder = Ladder.of(height, Width.from(players.size()), new RandomStatusGenerator());

        outputView.printResult(players.getNames(), ladder.getLines());
    }
}
