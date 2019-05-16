package ladder.controller;

import ladder.model.Ladder;
import ladder.model.LadderGameResult;
import ladder.model.Players;
import ladder.view.InputView;
import ladder.view.OutputView;

public class MainController {
    public static void main(String[] args) {
        String[] scannedNames = InputView.inputNames();
        String[] scannedLadderGameResult = InputView.inputLadderGameResult();
        int height = InputView.inputLadderHeight();

        Players players = new Players(scannedNames);
        Ladder ladder = new Ladder(height, scannedNames.length);
        LadderGameResult ladderGameResult = new LadderGameResult(scannedLadderGameResult,scannedNames.length);
        OutputView.printResultOfLadder(players, ladder, ladderGameResult);

    }
}
