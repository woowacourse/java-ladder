package ladder.controller;

import java.util.Collections;
import java.util.List;
import ladder.domain.LadderGame;
import ladder.domain.Line;
import ladder.view.InputView;
import ladder.view.OutputView;

public class LadderGameController {

    public void run() {
        List<String> players = InputView.askPlayerNames();

        LadderGame game = new LadderGame(players);
        int height = InputView.askLadderHeight();
        // TODO destination 입력받기
        List<Line> result = game.play(height, Collections.nCopies(players.size(), "dummy"));

        OutputView.showGameResult(game.getPlayerNames(), result);
    }
}
