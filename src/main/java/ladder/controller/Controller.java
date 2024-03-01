package ladder.controller;

import static ladder.domain.player.Player.ALL;

import ladder.domain.attribute.Height;
import ladder.domain.attribute.Width;
import ladder.domain.game.LadderGame;
import ladder.domain.game.LadderGameResult;
import ladder.domain.ladder.Ladder;
import ladder.domain.ladder.LadderBuilder;
import ladder.domain.ladder.LadderRow;
import ladder.domain.ladder.direction.DefaultLadderDirectionSelector;
import ladder.domain.ladder.direction.LadderDirection;
import ladder.domain.player.Player;
import ladder.domain.player.Players;
import ladder.domain.reward.Rewards;
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
        Rewards rewards = inputView.inputRewards(width);
        Height<LadderRow> height = inputView.inputHeight();
        Ladder ladder = createLadder(width, height);
        LadderGame ladderGame = LadderGame.of(players, rewards, ladder);
        LadderGameResult result = play(ladderGame);
        printLadderGameResult(result);
    }

    private Ladder createLadder(final Width<LadderDirection> width, final Height<LadderRow> height) {
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
        Player player = inputView.inputPlayerFrom(result);
        if (player == ALL) {
            resultView.printResult(result);
            return;
        }
        resultView.printReward(result.rewardOf(player));
        printLadderGameResult(result);
    }
}
