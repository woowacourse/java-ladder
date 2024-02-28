package ladder.controller;

import ladder.domain.DefaultLadderDirectionSelector;
import ladder.domain.Height;
import ladder.domain.Ladder;
import ladder.domain.LadderResults;
import ladder.domain.Players;
import ladder.view.InputView;
import ladder.view.ResultView;

public class Controller {

    public void run() {
        Players players = InputView.inputNames();
        LadderResults results = InputView.inputLadderResults();
        Height height = InputView.inputHeight();
        Ladder ladder = Ladder.of(players, height, new DefaultLadderDirectionSelector());
        ResultView.printResult(players, ladder);
    }
}
