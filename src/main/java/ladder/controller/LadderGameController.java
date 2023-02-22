package ladder.controller;

import java.util.List;
import ladder.domain.LadderGame;
import ladder.domain.Line;
import ladder.view.InputView;
import ladder.view.OutputView;

public class LadderGameController {

    public void run() {
        List<String> players = InputView.askPlayerNames();

        LadderGame game = new LadderGame(players);
        List<String> results = InputView.askLadderResults();
        int height = InputView.askLadderHeight();
        List<Line> result = game.play(height, results);

        OutputView.showGameResult(game.getPlayerNames(), result);
    }
}
