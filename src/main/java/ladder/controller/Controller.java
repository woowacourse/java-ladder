package ladder.controller;

import ladder.domain.DefaultLadderDirectionSelector;
import ladder.domain.Height;
import ladder.domain.Ladder;
import ladder.domain.LadderResults;
import ladder.domain.Players;
import ladder.view.InputView;
import ladder.view.ResultView;

public class Controller {

    private final InputView inputView;
    private final ResultView resultView;

    public Controller(final InputView inputView, final ResultView resultView) {
        this.inputView = inputView;
        this.resultView = resultView;
    }

    public void run() {
        Players players = inputView.inputNames();
        LadderResults results = inputView.inputLadderResults(players);
        Height height = inputView.inputHeight();
        Ladder ladder = Ladder.of(players, height, new DefaultLadderDirectionSelector());
        resultView.printLadder(players, ladder, results);
    }
}
