package ladder.controller;

import ladder.model.Ladder;
import ladder.model.LadderGameGoals;
import ladder.model.LadderGamePlayers;
import ladder.model.LadderGameResult;
import ladder.validator.LadderGameResultValidator;
import ladder.view.InputView;
import ladder.view.OutputView;

public class LadderGameController {

    private static final String PROGRAM_EXIT = "exit";
    private static final String SHOW_RESULT_All = "all";

    public void run() {
        LadderGamePlayers players = new LadderGamePlayers(InputView.makeLadderPlayers());
        LadderGameGoals goals = new LadderGameGoals(InputView.makeLadderGoals(players.size()));
        Ladder ladder = new Ladder(players, InputView.makeLadderHeight(), goals.getMaxLenOfGoalNames());

        OutputView.showLadderGame(players.getAlignedNames(goals.getMaxLenOfGoalNames()), ladder, goals.getAlignedGoalNames());
        LadderGameResult ladderGameResult = new LadderGameResult(players, ladder, goals);

        findMatching(ladderGameResult);
    }

    private void findMatching(LadderGameResult ladderGameResult) {
        String foundName = InputView.findName();
        while (!foundName.equals(PROGRAM_EXIT)) {
            showGameResults(ladderGameResult, foundName);
            foundName = InputView.findName();
        }
    }

    private void showGameResults(LadderGameResult ladderGameResult, String foundName) {
        if (foundName.equals(SHOW_RESULT_All)) {
            OutputView.showGameResult(ladderGameResult.toString());
            return;
        }
        OutputView.showGameResult(matchGameResult(ladderGameResult, foundName));
    }

    private String matchGameResult(LadderGameResult ladderGameResult, String foundName) {
        try {
            return LadderGameResultValidator.checMatchPlayerAndGoal(ladderGameResult.match(foundName));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
