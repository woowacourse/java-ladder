package ladder.controller;

import ladder.model.*;
import ladder.view.InputView;
import ladder.view.OutputView;

public class LadderGameController {
    public static final String EXIT_PROGRAM = "exit";
    public static final String ALL_RESULTS = "all";

    public void run() {
        LadderGamePlayers players = InputView.createLadderGamePlayers();
        LadderGameGoals goals = InputView.createLadderGameGoals(players.size());
        LadderHeight height = InputView.createLadderHeight();
        Ladder ladder = new Ladder(players, height);
        LadderGameResult ladderGameResult = new LadderGameResult(players, ladder, goals);

        OutputView.showLadderGame(players, ladder, goals);

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
        OutputView.showMatchingResult(ladderGameResult.matchResult(targetPlayerName));
    }
}
