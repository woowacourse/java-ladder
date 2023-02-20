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
        try {
            Players players = inputView.readUserNames();
            Height height = inputView.readHeight();
            Ladder ladder = new Ladder(players, height, trueOrFalseGenerator);
            outputView.printResult(players.getPlayers(), ladder.getLines(), players.getMaxPlayerNameLength());
        } catch (IllegalArgumentException e) {
            outputView.printErrormessage(e.getMessage());
        }
    }
}
