package ladder.controller;

import ladder.domain.LadderGame;
import ladder.utils.LineStrategy;
import ladder.view.InputView;
import ladder.view.OutputView;

import java.util.List;

public class LadderGameController {

    public void run(LineStrategy lineStrategy) {
        List<String> names = InputView.readNames();
        int height = InputView.readLadderHeight();
        LadderGame game = new LadderGame(names, height, lineStrategy);
        OutputView.printLadder(names, game.getLines(), game.getNameMaxLength());
    }
}
