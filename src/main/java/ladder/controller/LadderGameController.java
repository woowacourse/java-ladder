package ladder.controller;

import ladder.model.Ladder;
import ladder.model.LadderGameGoals;
import ladder.model.LadderGamePlayers;
import ladder.model.LadderGameResult;
import ladder.view.InputView;
import ladder.view.OutputView;

public class LadderGameController {
    public static final String EXIT_PROGRAM = "exit";
    public static final String ALL_RESULTS = "all";

    public void run() {
        LadderGamePlayers players = InputView.createLadderGamePlayers();
        LadderGameGoals goals = new LadderGameGoals(InputView.createLadderGoals(players.size()));
        Ladder ladder = new Ladder(players, InputView.createLadderHeight());
        LadderGameResult ladderGameResult = new LadderGameResult(players, ladder, goals);

        OutputView.showLadderGame(players.getAllAlignedPlayerNames(), ladder, goals.getAlignedGoalNames());

        showMatchingResults(ladderGameResult);
    }

    private void showMatchingResults(LadderGameResult ladderGameResult) {
        String targetPlayerName = InputView.getPlayerNameForFindingResult();
        while (!targetPlayerName.equals(EXIT_PROGRAM)) {
            showMatchingResult(ladderGameResult, targetPlayerName);
            targetPlayerName = InputView.getPlayerNameForFindingResult();
        }
    }

    private void showMatchingResult(LadderGameResult ladderGameResult, String targetPlayerName) {
        if (targetPlayerName.equals(ALL_RESULTS)) {
            OutputView.showMatchingResult(ladderGameResult.toString());
            return;
        }
        OutputView.showMatchingResult(matchResult(ladderGameResult, targetPlayerName));
    }

    private String matchResult(LadderGameResult ladderGameResult, String targetPlayerName) {
        try {
            return ladderGameResult.matchGoalWith(targetPlayerName);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
