package ladder.controller;

import ladder.model.Ladder;
import ladder.model.LadderGame;
import ladder.model.LadderGameResult;
import ladder.model.Players;
import ladder.view.InputView;
import ladder.view.OutputView;

import java.util.Arrays;

public class MainController {
    private static final String ALL_PLAYERS = "all";

    public static void main(String[] args) {
        String[] scannedNames = Arrays.stream(InputView.inputNames()).map(String::trim).toArray(String[]::new);
        String[] scannedLadderGameResult = Arrays.stream(InputView.inputLadderGameResult()).map(String::trim).toArray(String[]::new);
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
        String scannedDesiredResult = InputView.inputDesiredResult().trim();
        while (!scannedDesiredResult.equals(ALL_PLAYERS)) {
            OutputView.printResultOfExecution(ladderGame.getResultByName(scannedDesiredResult));
            scannedDesiredResult = InputView.inputDesiredResult();
        }
        OutputView.printResultOfExecution(ladderGame.getAllResult());
    }
}
