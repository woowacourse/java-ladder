package ladder.controller;

import static ladder.domain.Player.ALL;

import java.util.Map;

import ladder.domain.DefaultLadderDirectionSelector;
import ladder.domain.Height;
import ladder.domain.Ladder;
import ladder.domain.LadderBuilder;
import ladder.domain.LadderDirection;
import ladder.domain.LadderGame;
import ladder.domain.LadderResult;
import ladder.domain.LadderResults;
import ladder.domain.LadderRow;
import ladder.domain.Player;
import ladder.domain.Players;
import ladder.domain.Width;
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
        Width<LadderDirection> width = new Width<>(players.count());
        LadderResults ladderResults = inputView.inputLadderResults(width);
        Height<LadderRow> height = inputView.inputHeight();
        Ladder ladder = createLadder(width, height);
        LadderGame ladderGame = LadderGame.of(players, ladderResults, ladder);
        Map<Player, LadderResult> ladderGameResult = play(ladderGame);
        printLadderGameResults(ladderGameResult);
    }

    private Ladder createLadder(final Width<LadderDirection> width, final Height<LadderRow> height) {
        return LadderBuilder.builder()
                .width(width)
                .height(height)
                .ladderDirectionSelector(new DefaultLadderDirectionSelector())
                .build();
    }

    private Map<Player, LadderResult> play(final LadderGame ladderGame) {
        resultView.printLadderGame(ladderGame);
        return ladderGame.play();
    }

    private void printLadderGameResults(final Map<Player, LadderResult> ladderGameResults) {
        while (true) {
            Player player = inputView.inputPlayerFrom(ladderGameResults);
            if (player.equals(ALL)) {
                resultView.printAllResult(ladderGameResults);
                break;
            }
            resultView.printResult(ladderGameResults.get(player));
        }
    }
}
