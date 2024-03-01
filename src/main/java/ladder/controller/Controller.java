package ladder.controller;

import static ladder.domain.Player.ALL;

import java.util.Map;

import ladder.domain.DefaultLadderDirectionSelector;
import ladder.domain.Height;
import ladder.domain.Ladder;
import ladder.domain.LadderGame;
import ladder.domain.LadderResult;
import ladder.domain.LadderResults;
import ladder.domain.LadderRow;
import ladder.domain.Player;
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
        LadderResults ladderResults = inputView.inputLadderResults(players);
        Height<LadderRow> height = inputView.inputHeight();
        Ladder ladder = Ladder.of(players, height, new DefaultLadderDirectionSelector());
        LadderGame ladderGame = new LadderGame(players, ladderResults, ladder);
        resultView.printLadder(players, ladder, ladderResults);
        Map<Player, LadderResult> climbResults = ladderGame.play();
        while (true) {
            Player player = inputView.inputPlayerFrom(players);
            if (player.equals(ALL)) {
                resultView.printAllResult(climbResults);
                break;
            }
            resultView.printResult(climbResults.get(player));
        }
    }
}
