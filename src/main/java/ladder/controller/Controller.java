package ladder.controller;

import static ladder.domain.player.Player.ALL;

import java.util.Map;

import ladder.domain.attribute.Height;
import ladder.domain.attribute.Width;
import ladder.domain.ladder.Ladder;
import ladder.domain.ladder.LadderBuilder;
import ladder.domain.ladder.LadderGame;
import ladder.domain.ladder.LadderRow;
import ladder.domain.ladder.direction.DefaultLadderDirectionSelector;
import ladder.domain.ladder.direction.LadderDirection;
import ladder.domain.ladder.reward.Reward;
import ladder.domain.ladder.reward.Rewards;
import ladder.domain.player.Player;
import ladder.domain.player.Players;
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
        Map<Player, Reward> ladderGameResult = play(ladderGame);
        printLadderGameResults(ladderGameResult);
    }

    private Ladder createLadder(final Width<LadderDirection> width, final Height<LadderRow> height) {
        return LadderBuilder.builder()
                .width(width)
                .height(height)
                .ladderDirectionSelector(new DefaultLadderDirectionSelector())
                .build();
    }

    private Map<Player, Reward> play(final LadderGame ladderGame) {
        resultView.printLadderGame(ladderGame);
        return ladderGame.play();
    }

    private void printLadderGameResults(final Map<Player, Reward> ladderGameResults) {
        while (true) {
            Player player = inputView.inputPlayerFrom(ladderGameResults);
            if (player.equals(ALL)) {
                resultView.printAllResult(ladderGameResults);
                break;
            }
            resultView.printReward(ladderGameResults.get(player));
        }
    }
}
