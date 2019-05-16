package ladder.controller;

import ladder.model.Ladder;
import ladder.model.LadderGame;
import ladder.model.LadderGameResult;
import ladder.model.Players;
import ladder.view.InputView;
import ladder.view.OutputView;

public class MainController {
    public static void main(String[] args) {
        String[] scannedNames = InputView.inputNames();
        String[] scannedLadderGameResult = InputView.inputLadderGameResult();
        int scannedHeight = InputView.inputLadderHeight();

        Players players = new Players(scannedNames);
        Ladder ladder = new Ladder(scannedHeight, scannedNames.length);
        LadderGameResult ladderGameResult = new LadderGameResult(scannedLadderGameResult, scannedNames.length);
        OutputView.printResultOfLadder(players, ladder, ladderGameResult);

        LadderGame ladderGame = new LadderGame(players, ladder, ladderGameResult);
        ladderGame.playGame();

        playQnA(ladderGame);
    }

    private static void playQnA(LadderGame ladderGame) {
        String scannedDesiredResult = InputView.inputDesiredResult();
        while (!scannedDesiredResult.equals("all")) {
            OutputView.printResultOfExecution(ladderGame.getResultByName(scannedDesiredResult));
            scannedDesiredResult = InputView.inputDesiredResult();
        }
        OutputView.printResultOfExecution(ladderGame.getAllResult());
    }
}
