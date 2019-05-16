package ladder.controller;

import ladder.model.Ladder;
import ladder.model.LadderGameGoals;
import ladder.model.LadderGamePlayers;
import ladder.view.InputView;
import ladder.view.OutputView;

public class LadderGameController {

    LadderGamePlayers players;
    LadderGameGoals goals;
    Ladder ladder;

    public void run() {
        players = new LadderGamePlayers(InputView.makeLadderPlayers());
        goals = new LadderGameGoals(InputView.makeLadderGoals(players.size()));
        ladder = new Ladder(players, InputView.makeLadderHeight(), goals.getMaxLenOfGoalNames());

        OutputView.showLadderGame(players.getAlignedNames(goals.getMaxLenOfGoalNames()), ladder, goals.getAlignedGoalNames());
    }


}
