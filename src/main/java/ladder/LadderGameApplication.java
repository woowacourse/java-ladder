package ladder;

import ladder.domain.*;
import ladder.generator.LadderGenerator;
import ladder.view.InputView;
import ladder.view.OutputView;

import java.util.List;

public class LadderGameApplication {

    public static void main(String[] args) {
        LadderGamePlayers players = InputView.createPlayers();
        LadderGameRewards rewards = InputView.createRewards(players.size());

        Ladder ladder = LadderGenerator.makeLadder(players.size(), InputView.getCountOfLines());
        OutputView.printLadder(players, ladder, rewards);

        GameResult result = ladder.getResult(players, rewards);

        OutputView.printResult(result);
    }
}