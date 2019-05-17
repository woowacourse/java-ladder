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
        String[] names = Arrays.stream(InputView.inputNames()).map(String::trim).toArray(String[]::new);
        String[] gameResults = Arrays.stream(InputView.inputLadderGameResult()).map(String::trim).toArray(String[]::new);
        int height = InputView.inputLadderHeight();

        Players players = new Players(names);
        Ladder ladder = new Ladder(height, names.length);
        LadderGameResult ladderGameResult = new LadderGameResult(gameResults, names.length);
        OutputView.printResultOfLadder(players, ladder, ladderGameResult);

        LadderGame ladderGame = new LadderGame(players, ladder, ladderGameResult);
        ladderGame.playGame();

        String desiredResult = InputView.inputDesiredResult().trim();
        while (!desiredResult.equals(ALL_PLAYERS)) {
            OutputView.printResultOfExecution(ladderGame.getResultByName(desiredResult));
            desiredResult = InputView.inputDesiredResult();
        }
        OutputView.printResultOfExecution(ladderGame.getAllResult());
    }
}
