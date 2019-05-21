package ladder.controller;

import ladder.MessageCollection;
import ladder.model.Ladder;
import ladder.model.LadderGameGoals;
import ladder.model.LadderGamePlayers;
import ladder.model.LadderGameResult;
import ladder.view.InputView;
import ladder.view.OutputView;

public class LadderGameController {

    private static final String PROGRAM_EXIT = "exit";
    private static final String SHOW_RESULT_All = "all";

    private InputView inputView;
    private OutputView outputView;

    public LadderGameController(){
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void run() {
        LadderGamePlayers players = new LadderGamePlayers(inputView.makeLadderPlayers());
        LadderGameGoals goals = new LadderGameGoals(inputView.makeLadderGoals(players.size()));
        Ladder ladder = new Ladder(players, inputView.makeLadderHeight(), goals.getMaxLenOfGoalNames());

        outputView.showLadderGame(players.getAlignedNames(goals.getMaxLenOfGoalNames()), ladder, goals.getAlignedGoalNames());
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
            outputView.showGameResult(ladderGameResult.toString());
            return;
        }
        outputView.showGameResult(matchGameResult(ladderGameResult, foundName));
    }

    private String matchGameResult(LadderGameResult ladderGameResult, String foundName) {
        try {
            return checkMatchPlayerAndGoal(ladderGameResult.match(foundName));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    private String checkMatchPlayerAndGoal(String targetPlayer) {
        if (targetPlayer == null || targetPlayer.equals("")) {
            throw new IllegalArgumentException(MessageCollection.ERROR_PLAYER_NOT_EXIST);
        }
        return targetPlayer;
    }
}
