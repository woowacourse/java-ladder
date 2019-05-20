package ladder.controller;

import ladder.model.*;
import ladder.view.InputView;
import ladder.view.OutputView;

public class MainController {
    private static final String ALL = "all";

    public static void main(String[] args) {
        String[] scannedNames = InputView.inputNames();
        String[] scannedLadderGameResult = InputView.inputLadderGameResult();
        int scannedHeight = InputView.inputLadderHeight();

        Players players = new Players(scannedNames);
        Ladder ladder = new Ladder(scannedHeight, scannedNames.length);
        LadderGameResults ladderGameResults = new LadderGameResults(scannedLadderGameResult, scannedNames.length);
        OutputView.printResultOfLadder(players, ladder, ladderGameResults);

        LadderGame ladderGame = new LadderGame(players, ladder, ladderGameResults);
        GameResult gameResult = ladderGame.playGame();

        playQnA(gameResult, players);
    }

    private static void playQnA(GameResult gameResult, Players players) {
        String scannedName = InputView.inputDesiredResult();
        while (!scannedName.equals(ALL)) {
            OutputView.printResultOfExecution(gameResult.getResultByName(players, scannedName));
            scannedName = InputView.inputDesiredResult();
        }
        OutputView.printResultOfExecution(gameResult.getAllResult(players));
    }
}
