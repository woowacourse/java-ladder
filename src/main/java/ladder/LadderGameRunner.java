package ladder;

import ladder.domain.attribute.Height;
import ladder.domain.attribute.Width;
import ladder.domain.game.LadderGame;
import ladder.domain.game.LadderGameResult;
import ladder.domain.ladder.Ladder;
import ladder.domain.player.Players;
import ladder.domain.reward.Rewards;
import ladder.view.InputView;
import ladder.view.LadderGameResultCommand;
import ladder.view.ResultView;

public class LadderGameRunner {

    private final InputView inputView;
    private final ResultView resultView;

    public LadderGameRunner(final InputView inputView, final ResultView resultView) {
        this.inputView = inputView;
        this.resultView = resultView;
    }

    public void run() {
        Players players = inputView.inputNames();
        Width width = new Width(players.count());
        Rewards rewards = inputView.inputRewards(width);
        Height height = inputView.inputHeight();
        Ladder ladder = Ladder.of(height, width);
        LadderGame ladderGame = LadderGame.of(players, rewards, ladder);
        LadderGameResult result = play(ladderGame);
        askCommandAndPrintResult(result);
    }

    private LadderGameResult play(final LadderGame ladderGame) {
        resultView.printLadderGame(ladderGame);
        return ladderGame.play();
    }

    private void askCommandAndPrintResult(final LadderGameResult result) {
        LadderGameResultCommand resultCommand = inputView.inputGameResultCommand(result);
        resultView.printResult(result, resultCommand);
        if (resultCommand.isAll()) {
            return;
        }
        askCommandAndPrintResult(result);
    }
}
