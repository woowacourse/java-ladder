package ladder;

import ladder.domain.*;
import ladder.view.InputView;
import ladder.view.OutputView;

import java.util.List;

public class LadderMain {
    public static void main(String[] args) {
        InputView inputView = new InputView();

        String name = inputView.readName();
        String height = inputView.readHeight();
        String reward = inputView.readReward();

        Players players = new Players(name);
        int width = players.count();
        LadderRewards ladderRewards = new LadderRewards(reward, width);

        Ladder ladder = new Ladder(players.count(), height);
        ladder.make();

        OutputView outputView = new OutputView();
        outputView.print(players, ladder, ladderRewards);

        String playerName = inputView.readPlayer();
        LadderResult ladderResult = new LadderResult(ladderRewards);
        PlayerResult playerResult = ladderResult.run(ladder, players.player(playerName));

        outputView.print(playerResult);

        String allPlayer = inputView.readPlayer();
        List<PlayerResult> all = ladderResult.run(ladder, players);
        System.out.println(outputView.result(all));

    }
}
