package ladder.controller;

import ladder.domain.attribute.Height;
import ladder.domain.attribute.Width;
import ladder.domain.game.LadderGame;
import ladder.domain.game.LadderGameResult;
import ladder.domain.ladder.Ladder;
import ladder.domain.ladder.LadderBuilder;
import ladder.domain.ladder.direction.DefaultLadderDirectionSelector;
import ladder.domain.player.Player;
import ladder.domain.player.Players;
import ladder.domain.reward.Rewards;
import ladder.view.InputView;
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
        Ladder ladder = createLadder(width, height);
        LadderGame ladderGame = LadderGame.of(players, rewards, ladder);
        LadderGameResult result = play(ladderGame);
        printLadderGameResult(result);
    }

    private Ladder createLadder(final Width width, final Height height) {
        return LadderBuilder.builder()
                .width(width)
                .height(height)
                .ladderDirectionSelector(new DefaultLadderDirectionSelector())
                .build();
    }

    private LadderGameResult play(final LadderGame ladderGame) {
        resultView.printLadderGame(ladderGame);
        return ladderGame.play();
    }

    private void printLadderGameResult(final LadderGameResult result) {
        Player player = inputView.inputPlayerOrAll(result);
        resultView.printResult(result, player);
        if (player.isAll()) {
            return;
        }
        printLadderGameResult(result);
    }
}
