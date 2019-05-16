package ladder.controller;

import ladder.constant.MessageConstant;
import ladder.model.Ladder;
import ladder.model.LadderGameGoals;
import ladder.model.LadderGamePlayers;
import ladder.model.LadderGameResult;
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
        LadderGameResult ladderGameResult = new LadderGameResult(players,ladder,goals);

        String foundName = InputView.findName();
        if(foundName.equals("all")){
            OutputView.showGameResult(ladderGameResult.toString());
        }
        if(!players.existName(foundName)){
            throw new IllegalArgumentException(MessageConstant.ERROR_PLAYER_NOT_EXIST);
        }

        OutputView.showGameResult(ladderGameResult.match(foundName));

    }


}
