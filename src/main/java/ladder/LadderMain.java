package ladder;

import ladder.domain.*;
import ladder.view.InputView;
import ladder.view.OutputView;

public class LadderMain {


    public static void main(String[] args) {
        Players players = new Players(InputView.readName());
        LadderRewards rewards = new LadderRewards(InputView.readReward(), players.count());

        Ladder ladder = new Ladder().init(players.count(), InputView.readHeight());
        OutputView outputView = new OutputView();
        outputView.print(players, ladder, rewards);

        LadderResults ladderResults = LadderResultGenerator.result(ladder, players, rewards);
        outputView.printResult(ladderResults.result(InputView.readPlayer()));
    }
}
