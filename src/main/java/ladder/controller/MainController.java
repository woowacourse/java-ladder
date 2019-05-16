package ladder.controller;

import ladder.model.Ladder;
import ladder.model.Players;
import ladder.view.InputView;
import ladder.view.OutputView;

public class MainController {
    public static void main(String[] args) {
        String[] names = InputView.inputNames();
        int height = InputView.inputLadderHeight();

        Players players=new Players(names);
        Ladder ladder=new Ladder(height,names.length);
        OutputView.printResultOfLadder(players, ladder);

    }
}
